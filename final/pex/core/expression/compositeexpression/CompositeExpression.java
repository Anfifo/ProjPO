package pex.core.expression.compositeexpression;

/**
 * Composite Expression <p>
 * See Expression
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;
import pex.core.expression.literal.Literal;



public abstract class CompositeExpression extends Expression{

	public abstract String getAsText();

	public abstract Literal accept(ExpressionVisitor visitor);
}