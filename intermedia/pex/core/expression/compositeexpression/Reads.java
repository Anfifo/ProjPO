package pex.core.expression.compositeexpression;

import pex.core.expression.literal.Literal;

public class Reads extends CompositeExpression{

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(reads)";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
	}
}