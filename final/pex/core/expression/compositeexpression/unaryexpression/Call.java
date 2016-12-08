package pex.core.expression.compositeexpression.unaryexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;
import pex.core.ExpressionVisitor;
import pex.core.Interpreter;


public class Call extends UnaryExpression{
	/**
	 * attribute containing the programs that can be called
	 */
	private Interpreter _interpreter;



	/**
	 * default Constructor
	 * @param  exp1 first argument expression
	 */
	public Call(Expression exp1, Interpreter interpreter){
		super(exp1);
		_interpreter = interpreter;
	}



	/**
	 * returns the interpreter on which the program to be called can be found
	 * @return the interpreter which holds the programs the interpreter can call
	 */
	public Interpreter getInterpreter(){
		return _interpreter;
	}


	/**
	 * returns the operator that represents this composite expression
	 * @return the string representation
	 */
	public String getOperator(){
		return "call";
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
