package pex.core.expression.compositeexpression.binaryexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

public abstract class VariadicExpression extends CompositeExpression{

	private List<Expression> _arguments;
	
	public VariadicExpression(List<Expression> expressions){
		_arguments = expressions;
	}

	public List<Expression> getArguments(){
		return _arguments;
	}
}