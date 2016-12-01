package pex.core.expression.compositeexpression.binaryexpression;

/**
 * Class Binary Expression<p>
 * It's a composite expression composed by an operator and 2 expression.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;
import pex.core.expression.ExpressionVisitor;


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

	public abstract String getOperator();

	public String getAsText(){
		return "("+ this.getOperator() + " "+ getFirstArgument().getAsText() +" "+  getSecondArgument().getAsText() + ")";
	}
}