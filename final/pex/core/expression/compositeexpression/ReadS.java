package pex.core.expression.compositeexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.expression.ExpressionVisitor;

public class ReadS extends CompositeExpression{


	public ReadS(){
		
	}

	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(reads)";
	}


	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}

	
	public void accept(ExpressionVisitor visitor){
		visitor.visit(this);
	}
}