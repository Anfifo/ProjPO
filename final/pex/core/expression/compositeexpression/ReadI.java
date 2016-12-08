package pex.core.expression.compositeexpression;

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


public class ReadI extends CompositeExpression{
	/**
	 * The app containing the input reading methods needed
	 */
	private AppIO _app;




	/**
	 * default constructor
	 * @param  AppIO app           app with the input reading methods
	 */
	public ReadI(AppIO app){
		_app = app;
	}




	/**
	 * return the app that this class will use for input
	 * @return the app the class uses
	 */
	public AppIO getAppIO(){
		return _app;
	}


	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
		return "(readi)";
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
