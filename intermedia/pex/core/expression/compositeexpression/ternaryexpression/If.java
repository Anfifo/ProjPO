package pex.core.expression.compositeexpression.trenaryexpression;

import pex.core.expression.literal;

public class If extends TrenaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 * @param  exp3 third argument expression
	 */
	public If(Expression exp1, Expression exp2, Expression exp3){
		super(exp1, exp2, exp3);
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(if "+ super.getFirstArgument() + " " +  super.getSecondArgument() + " " + super.getThirdArgument() +")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
	}
}