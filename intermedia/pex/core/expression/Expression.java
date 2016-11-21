package pex.core.expression;

import pex.core.expression.literal.Literal;


/**
 * Abstract class for an Expression
 * FINISH ME!
 */

public abstract class Expression{
	
	public abstract String getAsText();

	public abstract Literal evaluate();
}