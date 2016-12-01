package pex.core.expression.compositeexpression.binaryexpression;

/**
 *
 * Projeto PO
 * Grupo nr 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.expression.ExpressionVisitor;


public class Div extends BinaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Div(Expression exp1, Expression exp2){
		super(exp1, exp2);
	}

	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "div";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}

	
	public void accept(ExpressionVisitor visitor){
		visitor.visit(this);
	}

}