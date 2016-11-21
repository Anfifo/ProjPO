package pex.core.expression.compositeexpression.variadicexpression;

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;

import java.util.*;

public abstract class VariadicExpression extends CompositeExpression{

	private List<Expression> _arguments;
	
	public VariadicExpression(List<Expression> expressions){
		_arguments = expressions;
	}

	public List<Expression> getArguments(){
		return _arguments;
	}
}