package pex.core.expression.compositeexpression.variadicexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;
import pex.AppIO;

import java.util.*;


public class Print extends VariadicExpression{
	/**
	 * app with the intput/output methods to be used along wiht this function
	 */
	private AppIO _app;



	/**
	 * default Constructor
	 * @param  exp1 List with all "arguments"
	 */
	public Print(List <Expression> expressions, AppIO app){
		super(expressions);
		_app = app;
	}



	/**
	 * return the app with the input/output methods
	 * @return return the app attribute
	 */
	public AppIO getAppIO(){
		return _app;
	}



	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "print";
	}



	/**
	 * function allowing use of visitor pattern
	 * @see ExpressionVisitor @ pex.core
	 * @param  ExpressionVisitor visitor       the concrete visitor to be used
	 * @return                   the value returned, if not needed return null
	 */
	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}
