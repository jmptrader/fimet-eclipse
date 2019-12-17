package com.fimet.evaluator.operator.impl;

import com.fimet.commons.exception.ParserFormulaException;
import com.fimet.evaluator.operator.OperatorBinary;
import com.fimet.evaluator.type.Expression;
import com.fimet.evaluator.type.TypeBoolean;
/**
 * 
 * @author Marco A. Salazar
 * @email marcoasb99@ciencias.unam.mx
 *
 */
public class And extends OperatorBinary {
	public String getName() {
		return "&&";
	}
	public int getPrecedence() {
		return PRECEDENCE1;
	}
	public TypeBoolean eval(Expression v0, Expression v1){
		if (v0.getType() == TypeBoolean.class && v1.getType() == TypeBoolean.class) {
			if (!((TypeBoolean)v0.eval()).getValue()) {
				return TypeBoolean.FALSE;
			} else if(!((TypeBoolean)v1.eval()).getValue()) {
				return TypeBoolean.FALSE;
			} else {
				return TypeBoolean.TRUE;
			}
		}
		throw new ParserFormulaException("No existe el operador <"+left.getClass()+"> " + this.getName() + " <" + right.getClass() + ">");
	}
	public Class<?> getType(){
		return TypeBoolean.class;
	}
}
