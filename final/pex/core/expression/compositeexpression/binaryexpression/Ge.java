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
import pex.core.ExpressionVisitor;


public class Ge extends BinaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Ge(Expression exp1, Expression exp2){
		super(exp1, exp2);
	}

	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "ge";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}

	

	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}

}