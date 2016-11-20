package pex.core.expression.compositeexpression.unaryexpression;

import pex.core.expression.literal;

public class Not extends UnaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 */
	public Not(Expression exp1){
		super(exp1);
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(not "+ super.getFirstArgument().getAsText() +" "+  super.getSecondArgument().getAsText() + " "+ super.getThirdArgument().getAsText() +")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
	}
}