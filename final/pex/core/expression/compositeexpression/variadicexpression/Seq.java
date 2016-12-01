package pex.core.expression.compositeexpression.variadicexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.expression.ExpressionVisitor;

import java.util.*;


public class Seq extends VariadicExpression{

	/**
	 * default Constructor
	 * @param  exp1 List with all "arguments"
	 */
	public Seq(List <Expression> expressions){
		super(expressions);
	}




	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "seq";
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