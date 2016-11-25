package pex.core.expression.compositeexpression.ternaryexpression;

/**
 * Ternary Expression<p>
 * Composite expression with 3 Expressions.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class TernaryExpression extends CompositeExpression{
	private Expression _firstArgument;
	private Expression _secondArgument;
	private Expression _thirdArgument;




	/**
	 * Default constructor
	 * @param  arg1 First Expression
	 * @param  arg2 Second Expression
	 * @param  arg3 Third Expression
	 */
	public TernaryExpression(Expression arg1, Expression arg2, Expression arg3){
		_firstArgument = arg1;
		_secondArgument = arg2;
		_thirdArgument = arg3;
	}

	public Expression getFirstArgument(){
		return _firstArgument;
	}

	public Expression getSecondArgument(){
		return _secondArgument;
	}

	public Expression getThirdArgument(){
		return _thirdArgument; 
	}

}