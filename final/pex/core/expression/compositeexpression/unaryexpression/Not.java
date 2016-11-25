package pex.core.expression.compositeexpression.unaryexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;


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
		return "(not "+ super.getArgument().getAsText()+")";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}