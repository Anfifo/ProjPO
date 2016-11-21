package pex.core.expression.compositeexpression;

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;

public abstract class CompositeExpression extends Expression{

	public abstract String getAsText();

	public abstract Literal evaluate();
}