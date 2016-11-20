package pex.core.expression.compositeexpression.binaryexpression;

import pex.core.expression.literal;

public class Mod extends BinaryExpression{

/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Mod(Expression exp1, Expression exp2){
		super(exp1, exp2);
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(mod "+ super.getFirstArgument().getAsText() +" "+  super.getSecondArgument().getAsText() + ")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
	}
}