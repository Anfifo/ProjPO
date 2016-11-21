package pex.core.expression.literal;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.Expression;

public abstract class Literal extends Expression{

	public abstract Literal evaluate();

	public abstract String getAsText();
}