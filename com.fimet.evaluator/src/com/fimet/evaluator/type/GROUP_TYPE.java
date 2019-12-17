package com.fimet.evaluator.type;

import com.fimet.evaluator.reader.ITokenReader;
import com.fimet.evaluator.token.TokenGroup;
/**
 * 
 * @author Marco A. Salazar
 * @email marcoasb99@ciencias.unam.mx
 *
 */
public class GROUP_TYPE extends Type {
	private Type expression;
	public GROUP_TYPE(ITokenReader reader) {
		reader.curr(TokenGroup.L_PARENTHESIS);
		expression = reader.nextType();
		reader.curr(TokenGroup.R_PARENTHESIS);
	}
	public String toString(){
		return "(" + expression + ")";
	}
	public Class<?> getType() {
		return expression.getType();
	}
	@Override
	public Object evaluate() {
		return expression.evaluate();
	}
}
