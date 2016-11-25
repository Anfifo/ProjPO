package pex.core.expression.compositeexpression.ternaryexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;

public class If extends TernaryExpression{

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
		return "(if "+ super.getFirstArgument().getAsText() + " " +  super.getSecondArgument().getAsText() + " " + super.getThirdArgument().getAsText() +")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}