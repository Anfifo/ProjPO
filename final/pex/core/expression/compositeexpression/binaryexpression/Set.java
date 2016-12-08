package pex.core.expression.compositeexpression.binaryexpression;

/**
 *
 * Projeto PO
 * Grupo nr 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;
import pex.core.Interpreter;


public class Set extends BinaryExpression{
	/**
	 * attribute containing the identifiers which can be Set
	 */
	private Interpreter _interpreter;



	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 * @param  exp2 second argument expression
	 */
	public Set(Expression exp1, Expression exp2, Interpreter interpreter){
		super(exp1, exp2);
		_interpreter = interpreter;
	}



	/**
	* returns the interpreter attribute
	* @return the interpreter attribute
	*/
	public Interpreter getInterpreter(){
		return _interpreter;
	}



	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "set";
	}



	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
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
