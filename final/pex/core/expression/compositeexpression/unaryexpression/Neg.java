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


public class Neg extends UnaryExpression{

	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 */
	public Neg(Expression exp1){
		super(exp1);
	}

	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "neg";
	}



	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}
