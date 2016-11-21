package pex.core.expression.compositeexpression;

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;


public class ReadI extends CompositeExpression{

	public ReadI(){
		
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(readi)";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}