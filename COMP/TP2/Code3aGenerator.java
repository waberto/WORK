//Author: HOUSSEIN & LEDOUX


/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 * 
 * @author MLB
 * 
 */
public class Code3aGenerator {

	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}

	/**
	 * Generate code for a binary operation
	 * 
	 * @param op
	 *			must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genCopy(Operand3a var, ExpAttribute value) {
		Code3a code = value.code;
		code.append(new Inst3a(Inst3a.TAC.COPY, var, value.place, null));
		return code;
	}
	
	
	/**
	 * Generate code for a binary operation
	 * 
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1,	ExpAttribute exp2) {
		Code3a cod = exp1.code;
		cod.append(exp2.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return cod;
	}
	
	public static Code3a genUniOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1) {
		Code3a cod = exp1.code;
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, null));
		return cod;
	}
	

	/**
	 * Generates code for affectation
	**/
	public static Code3a genAssign(Operand3a var, ExpAttribute exp) {
		Code3a code = new Code3a();
		code.append(exp.code);
		code.append(new Inst3a(Inst3a.TAC.COPY, var, exp.place, null));
		return code;
	} 
	
	/** 
	 * Generate code for return
	*/
	public static Code3a genReturn(ExpAttribute e) {
		Code3a code = new Code3a();
		code.append(e.code);
		code.append(new Inst3a(Inst3a.TAC.RETURN, e.place, null, null));

		return code;
	}
	 
	/**
	 * Generates code for print text
	*/
	public static Code3a genPrintString(String text){
		Code3a code = new Code3a();
		Data3a data = new Data3a(text);
		code.appendData(data);		
		code.append(new Inst3a(Inst3a.TAC.ARG, data.getLabel(), null, null));
		code.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null));
		return code;
	}
	
	/**
	 * Generates code for print integer
	 */
	public static Code3a genPrintInteger(ExpAttribute e){
		Code3a code = new Code3a();
		code.append(e.code);
		code.append(new Inst3a(Inst3a.TAC.ARG,e.place, null, null));
		code.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintN, null));
		return code;
	} 
	
	/**
	 * Generates code for read integer
	 */
	public static Code3a genReadInteger(VarSymbol var){
		Code3a code = new Code3a();
		code.append(new Inst3a(Inst3a.TAC.CALL, var, SymbDistrib.builtinRead, null));
		return code;
	}
	
	/**
	 * Generates code for a argument call
	 */
	public static Code3a genArgument(ExpAttribute e){
		Code3a code = e.code;
		code.append(new Inst3a(Inst3a.TAC.ARG, e.place, null, null));
		return code;
		
	}
	
	/**
	 * Generates code for array_elem
	 */
	public static Code3a genArrayElem(Operand3a t, ExpAttribute e){
		Code3a code = new Code3a();
		Inst3a inst = new Inst3a(Inst3a.TAC.VARTAB, t, e.place, null);
		return code;
	}
	
	/**
	 * Generates code for array_elem...
	 */
	
	
	/** 
	 * Generate code for IF 
	*/
	public static Code3a genIF(ExpAttribute exp, Code3a code1) {
		LabelSymbol fin = SymbDistrib.newLabel();
		Code3a code = new Code3a();
		code.append(exp.code);
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, fin, null));
		code.append(code1);
		code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
		return code;
	}
	 

	/** 
	 * Generates code for IFELSE
	 */
	public static Code3a genIFELSE(ExpAttribute exp, Code3a code1, Code3a code2) {
		LabelSymbol cas2 = SymbDistrib.newLabel();
		LabelSymbol end = SymbDistrib.newLabel();
		Code3a code = new Code3a();
		code.append(exp.code);
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, cas2, null));
		code.append(code1);
		code.append(new Inst3a(Inst3a.TAC.GOTO, end, null, null));
		code.append(new Inst3a(Inst3a.TAC.LABEL, cas2, null, null));
		code.append(code2);
		code.append(new Inst3a(Inst3a.TAC.LABEL, end, null, null));
		return code;
	}
	
	/** 
	 * Generates code for WHILE
	 */
	public static Code3a genWHILE(ExpAttribute exp, Code3a code1){
		LabelSymbol b = SymbDistrib.newLabel();
		LabelSymbol fin = SymbDistrib.newLabel();
		Code3a code = new Code3a();
		code.append(new Inst3a(Inst3a.TAC.LABEL, b, null, null));
		code.append(exp.code);
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, fin, null));
		code.append(code1);
		code.append(new Inst3a(Inst3a.TAC.GOTO, b, null, null));
		code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
		return code;		
	}
	
	/**
	 * Generates code for a function call
	 */
	public static ExpAttribute genFunctionCall(String funcName, FunctionType f, Code3a c) {
		
		Code3a code;
		VarSymbol resultFunction = SymbDistrib.newTemp();
		ExpAttribute exp;
		
		
		if(c == null){
			code = genVar(resultFunction);
			code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, resultFunction, new LabelSymbol(funcName), null)));
			exp = new ExpAttribute(f.getReturnType(), code, resultFunction);
		}
		else{
			code = genVar(resultFunction);
			code.append(c);
			code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, resultFunction, new LabelSymbol(funcName), null)));
			exp = new ExpAttribute(f.getReturnType(), code, resultFunction);
		}
		
		return exp;
	}
	
	/**
	 * Generates code for a function call
	 */
	public static Code3a genFunCall_S(Operand3a id, Code3a arg, VarSymbol res){
		Code3a code = new Code3a();
		
		code.append(arg);
		if (code == null){
			code = new Code3a(new Inst3a(Inst3a.TAC.ARG, null, id, null));
		}
		else {
			code.append( new Inst3a(Inst3a.TAC.ARG, null, id, null));
		}
		
		return code;
	}
	
	

} // Code3aGenerator ***