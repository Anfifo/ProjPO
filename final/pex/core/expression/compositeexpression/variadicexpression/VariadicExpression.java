package pex.core.expression.compositeexpression.variadicexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

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

	public abstract String getOperator();


	public String getAsText(){

		int size = _arguments.size();
		
		int i = 0;

		String output = "(" + this.getOperator();

		for( i = 0; i < size; i++){
			output += " " + _arguments.get(i).getAsText();
		}
		output += ")";
 
		return output;
	}
}