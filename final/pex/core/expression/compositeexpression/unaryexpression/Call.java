package pex.core.expression.compositeexpression.unaryexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;


public class Call extends UnaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 */
	public Call(Expression exp1){
		super(exp1);
	}

	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "call";
	}


	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}
