package pex.core.expression.compositeexpression.binaryexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class BinaryExpression extends CompositeExpression{

	private Argument _firstArgument;
	private Argument _secondArgument;
	
	public Expression getFirstArgument(){
		return _firstArgument;
	}

	public Expression getSecondArgument(){
		return _secondArgument;
	}
}