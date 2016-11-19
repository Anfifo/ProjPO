package pex.core.Expression;

import pex.core.Expression.Literal;

/**
 * Abstract class for an Expression
 * FINISH ME!
 */

public abstract class Expression(){
	
	public abstract String getAsText();

	public abstract Literal evaluate();
}