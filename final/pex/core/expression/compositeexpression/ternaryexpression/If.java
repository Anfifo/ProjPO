package pex.core.expression.compositeexpression.ternaryexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;


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
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "if";
	}




	/**
	 * function allowing use of visitor pattern
	 * @see ExpressionVisitor @ pex.core
	 * @param  ExpressionVisitor visitor       the concrete visitor to be used
	 * @return                   the value returned, if not needed return null
	 */
	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}
