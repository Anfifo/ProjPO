package pex.core.expression.compositeexpression.binaryexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class BinaryExpression extends CompositeExpression{

	private Expression _firstArgument;
	private Expression _secondArgument;
	
	public BinaryExpression(Expression exp1, Expression exp2){
		_firstArgument = exp1;
		_secondArgument = exp2;
	}

	public Expression getFirstArgument(){
		return _firstArgument;
	}

	public Expression getSecondArgument(){
		return _secondArgument;
	}
}