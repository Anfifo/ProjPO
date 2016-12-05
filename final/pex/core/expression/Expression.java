package pex.core.expression;

/**
 *	Class Expression <p>
 *	An expression may represent a base expression like a Literal, which can be directly evaluated or a composite expression.
 *	A composite expression has an operator which may act upon more expressions. A Composite expression can be evaluated.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.ExpressionVisitor;


public abstract class Expression implements java.io.Serializable{
	/**
	 * The string representation of the expression.
	 * @return it's string representation.
	 */
	public abstract String getAsText();

	/**
	 * The evaluation or execution of an expression results in a base expression Literal.
	 * @return the result of it's execution.
	 */

	public abstract Literal accept (ExpressionVisitor expressionVisitor);
}