package pex.core.expression.compositeexpression.binaryexpression;

/**
 *
 * Projeto PO
 * Grupo nr 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.Expression;
import pex.core.expression.literal.Literal;
import pex.core.ExpressionVisitor;


public class Add extends BinaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Add(Expression exp1, Expression exp2){
		super(exp1, exp2);
	}

	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "add";
	}

	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}
