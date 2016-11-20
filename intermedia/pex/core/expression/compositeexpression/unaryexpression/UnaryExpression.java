package pex.core.expression.compositeexpression.unaryexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class UnaryExpression extends CompositeExpression{
	Expression _argument;

	public UnaryExpression(Expression exp){
		_argument = exp;
	}

	public Expression getArgument(){
		return _argument;
	}
}