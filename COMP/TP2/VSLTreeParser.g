tree grammar VSLTreeParser;

//Author: HOUSSEIN & LEDOUX

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}



//****************************************************************************************************


s[SymbolTable symTab] returns [Code3a code]
  :	p=program[symTab] { code = $p.code; }
  
  ;


//****************************************************************************************************


program [SymbolTable symTab] returns [Code3a code]
	: ^(PROG  { code = new Code3a(); }  (unit[symTab] { code.append($unit.code); } )+ )
;


//****************************************************************************************************

unit [SymbolTable symTab] returns [Code3a code]
    : f=function[symTab]
    	{
    		code = $f.code;
    	}
    | proto[symTab]
    	{
    		code = new Code3a();
    	}
    ;
    

//****************************************************************************************************

function  [SymbolTable symTab] returns [Code3a code]
    : ^(FUNC_KW t=type IDENT { FunctionType function = new FunctionType($t.type, false);} p=param_list[symTab, function]  ^(BODY st=statement[symTab]))
    	{
    		LabelSymbol functionLabel = new LabelSymbol($IDENT.text);
    		code=new Code3a();
    		code.append(new Inst3a(Inst3a.TAC.LABEL, functionLabel, null,null));
    		code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null,null));
    		code.append($p.code);
    		code.append(st);
    		code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null,null));
    	}
    ;


//****************************************************************************************************

proto [SymbolTable symTab]
    : ^(PROTO_KW t=type IDENT { FunctionType function = new FunctionType($t.type, true);} param_list[symTab,function]
    
    	{
			Operand3a id = $symTab.lookup($IDENT.text);
			if (id != null) Errors.redefinedIdentifier(null, $IDENT.text, null);
			LabelSymbol functionLabel = new LabelSymbol($IDENT.text);
			FunctionSymbol functionSymbol = new FunctionSymbol(functionLabel, function);
			symTab.insert($IDENT.text, functionSymbol);
			
		}
	)
    ;
    

//****************************************************************************************************

type returns [Type type]
    : INT_KW { type=Type.INT; } 
    | VOID_KW { type=Type.VOID; }
    ;
 

//****************************************************************************************************

param_list [SymbolTable symTab, FunctionType function ] returns [Code3a code]
    : ^(PARAM { code = new Code3a(); } (p=param[symTab, function]
    	{ 
    		code.append($p.code);
    	}
    		)*
    )
    ;

param [SymbolTable symTab, FunctionType function] returns [Code3a code] 
    : IDENT
    	{	
    	
    		function.extend(Type.INT);
    		VarSymbol v = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
    		v.setParam();
    		symTab.insert($IDENT.text,v);
    		code = Code3aGenerator.genVar(v);
    	}
    
    
    |^(ARRAY IDENT)
    	{
    		function.extend(Type.POINTER);
    		VarSymbol array = new VarSymbol(Type.POINTER, $IDENT.text, symTab.getScope());
    		array.setParam();
    		symTab.insert($IDENT.text,array);
    		code = Code3aGenerator.genVar(array);
    	}
    ;


//*************************************************************************************************

statement [SymbolTable symTab] returns [Code3a code]
	: ^(ASSIGN_KW e=expression[symTab] IDENT)
	{
		Operand3a id = symTab.lookup($IDENT.text);
		if (id == null) Errors.unknownIdentifier($ASSIGN_KW, $IDENT.text, null);
		Type ty = TypeCheck.checkBinOp(id.type, $e.expAtt.type);
		if (ty == Type.ERROR) Errors.incompatibleTypes($ASSIGN_KW, id.type, ty, null);
				
		code = Code3aGenerator.genCopy(id, e);
		
     }
       	
    | ^(RETURN_KW e=expression[symTab])
    	{
    		code = Code3aGenerator.genReturn($e.expAtt);
    	}
   
     
 	| ^(PRINT_KW p=print_list[symTab])
 		{
 			code = p;
 		}
 		
 	| ^(READ_KW r=read_list[symTab])
 		{
 			code = r;
 		}
 		
    
   	| ^(IF_KW e=expression[symTab] s1=statement[symTab] (s2=statement[symTab])? )
   		{
			if (s2 != null) code = Code3aGenerator.genIFELSE($e.expAtt, $s1.code, $s2.code);
			
			else code = Code3aGenerator.genIF($e.expAtt, $s1.code);		
   		}
   		
   	| ^( WHILE_KW e=expression[symTab] st=statement[symTab])
   		{
   			code = Code3aGenerator.genWHILE($e.expAtt, $st.code);
   		}
   	
  	| ^( FCALL_S IDENT arg=argument_list[symTab]?)
  		{
  			Operand3a idt = symTab.lookup($IDENT.text);
  			if(idt==null){
  				System.out.println("Fonction non existante !");
  				System.exit(1);
  			}
  			VarSymbol temp = SymbDistrib.newTemp();
  			code.append(Code3aGenerator.genVar(temp));
  			code.append(Code3aGenerator.genFunCall_S(idt, arg, temp));
  		}
   		
   	| b=block[symTab]
   		{
   			code = b;		
   		}
   		
     ;
     

//*****************************************************************************************     

block [SymbolTable symTab] returns [Code3a code]
    : ^(BLOCK dec=declaration[symTab] inst=inst_list[symTab]
    	{
    		symTab.enterScope();
    		code =dec;
    		code.append(inst);
    		symTab.leaveScope();
    	})
    | ^(BLOCK inst=inst_list[symTab]
    {	
    	symTab.enterScope();
    	code = inst;
    	symTab.leaveScope();
    })
    ;  

//*****************************************************************************************

array_elem [SymbolTable symTab] returns [Code3a code]
    : ^(ARELEM  IDENT e=expression[symTab])
    	{
    		Operand3a id = symTab.lookup($IDENT.text);
    		if (id == null) Errors.unknownIdentifier($IDENT, $IDENT.text, null);
    		code = Code3aGenerator.genArrayElem(id, $e.expAtt);
    	
    	}
    ;

//*******************************************************************************************	

inst_list [SymbolTable symTab] returns [Code3a code]
    : ^(INST {code = new Code3a();} 
    	
    	(st=statement[symTab] 
   
    	  { code.append(st); })+
    )
    ;

//******************************************************************************************

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(DIV e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(NEGAT e1=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkUniOp(e1.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genUniOp(Inst3a.TAC.NEG, temp, e1);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
    |pe=primary_exp[symTab] 
    { $expAtt = pe; }
  ;
  
  
  
//********************************************************************************************************  

primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      if (id == null) Errors.unknownIdentifier($IDENT, $IDENT.text, null);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  | array_elem[symTab]
    {
    		
    }
  | ^(FCALL IDENT arg=argument_list[symTab]?)
			{
				
				Operand3a function = $symTab.lookup($IDENT.text);
				if (function == null) Errors.unknownIdentifier($IDENT, $IDENT.text, null);
				expAtt = Code3aGenerator.genFunctionCall($IDENT.text, (FunctionType)function.type, $arg.code);
				
			}
		
 /* |  LP! expression[symTab] RP! 
  		{
  			expAtt = $expression.expAtt;
  		}*/
  ;
  
//*********************************************************************************************************

argument_list[SymbolTable symTab] returns [Code3a code]
    : { code = new Code3a(); } (e=expression[symTab] 
    { 	code.append(e.code);
    	code.append(new Inst3a(Inst3a.TAC.ARG, e.place, null, null));		
     })+
    ;

//*********************************************************************************************************

print_list [SymbolTable symTab] returns [Code3a code]
    : { code = new Code3a(); } ( p=print_item[symTab] { code.append(p); })+
    ;


print_item [SymbolTable symTab] returns [Code3a code]
    : t=TEXT
    	{
    		code = Code3aGenerator.genPrintString($t.text);
    	}
    | e=expression[symTab]
    	{
    		code = Code3aGenerator.genPrintInteger($e.expAtt);
    	}
   	
    ;

//**********************************************************************************************************
 
  
read_list [SymbolTable symTab] returns [Code3a code]
    : { code = new Code3a(); } ( r=read_item[symTab] { code.append(r); })+
    ;

read_item [SymbolTable symTab] returns [Code3a code]
    : id=IDENT
    	{
    		if( id == null) Errors.unknownIdentifier($id, $id.text, "");
    		
    		code = Code3aGenerator.genReadInteger((VarSymbol)symTab.lookup($id.text));
    	}
  	| array_elem[symTab]
    	{
    		
    	}
    ;

//*********************************************************************************************************** 
 
declaration [SymbolTable symTab] returns [Code3a code]
    : ^(DECL decl=decl_item[symTab] { code = decl;} 
    	(decl = decl_item[symTab]{ code.append(decl);})*
    )
    ;
     
decl_item [SymbolTable symTab] returns [Code3a code]
    : IDENT
    	 {
    	 	Operand3a id = symTab.lookup($IDENT.text);
    	 	if (id != null) Errors.redefinedIdentifier($IDENT, $IDENT.text, null);
    		VarSymbol v = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, v);
			code = Code3aGenerator.genVar(v);
		
		 }
	| ^(ARDECL IDENT INTEGER)
		{
			Operand3a id = symTab.lookup($IDENT.text);
			if (id != null) Errors.redefinedIdentifier($IDENT, $IDENT.text, null);
    		VarSymbol array = new VarSymbol(Type.POINTER, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, array);
			code = Code3aGenerator.genVar(array);
			} 
       ;
//*********************************************************************************************************