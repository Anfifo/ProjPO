package pex.core.expression.compositeexpression.binaryexpression;

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;


public class Gt extends BinaryExpression{

/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Gt(Expression exp1, Expression exp2){
		super(exp1, exp2);
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(gt "+ super.getFirstArgument().getAsText() +" "+  super.getSecondArgument().getAsText() + ")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}