package pex.core.expression.compositeexpression.ternaryexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class TernaryExpression extends CompositeExpression{
	private Expression _firstArgument;
	private Expression _secondArgument;
	private Expression _thirdArgument;

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