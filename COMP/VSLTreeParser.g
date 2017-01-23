tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
 
}

s [SymbolTable symTab] returns [Code3a code]
  : e=expression[symTab] { code = e.code; } | d = declaration[symTab] { code = d; }
  	 
   //|b=block[symTab] { code = b; }
   //|a=statement[symTab] { code = a; }
  ;
 /**
statement [SymbolTable symTab] returns [Code3a c]
	: ^(ASSIGN_KW a1=expression[symTab] IDENT)
	{
		//Type a = TypeCheck.checkUniOp(a1.type);
		//VarSymbol v = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
		//symTab.insert($IDENT.text, v);
		Operand3a id = symTab.lookup($IDENT.text);
		
		c = Code3aGenerator.genAssign(Inst3a.TAC.COPY, id, a1);
		
     }
    
block [SymbolTable symTab] returns [Code3a code]
    : ^(BLOCK decl = declaration[symTab] inst=inst_list[symTab])
    	{
    		symTab.enterScope();
    		code = decl;
    		code.append(inst);
    	}
    | ^(BLOCK inst = inst_list[symTab])
    {
    	symTab.enterScope();
    	code = inst;
    }
    ;    
    
inst_list [SymbolTable symTab] returns [Code3a code]
    : ^(INST st=statement[symTab] { code = st }
    
    	(st = statement[symTab] { code.append(st); })*
    )
    ;
      */  
declaration [SymbolTable symTab] returns [Code3a code]
    : ^(DECL c = decl_item[symTab] { code = c;} 
    	(c = decl_item[symTab]
    {
    	code.append(c);	
    })+
    )
    ;
 
decl_item [SymbolTable symTab] returns [Code3a code]
    : IDENT  {
    	VarSymbol v = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
		symTab.insert($IDENT.text, v);
		code = Code3aGenerator.genDecl(v);
		}
       ;
     
expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(DIV e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
    |^(NEGAT e1=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkUniOp(e1.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genUniOp(Inst3a.TAC.NEG, temp, e1);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
    |pe=primary_exp[symTab] 
    { expAtt = pe; }
  ;
  
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  ;
