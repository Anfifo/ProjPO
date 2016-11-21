package pex.core.expression.literal;

import pex.core.expression.Expression;

public abstract class Literal extends Expression{

	public abstract Literal evaluate();

	public abstract String getAsText();
}