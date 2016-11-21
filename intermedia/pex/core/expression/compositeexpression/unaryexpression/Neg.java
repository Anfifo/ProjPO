package pex.core.expression.compositeexpression.unaryexpression;

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;


public class Neg extends UnaryExpression{
	
	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 */
	public Neg(Expression exp1){
		super(exp1);
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(neg "+ super.getArgument().getAsText() +")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}