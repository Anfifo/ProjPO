package pex.core.expression.compositeexpression.unaryexpression;

/**
 * Unary Expression Class<p>
 * Composite Expression with 1 expression and an operator.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.Expression;
import pex.core.expression.compositeexpression.CompositeExpression;
import pex.core.ExpressionVisitor;
import pex.core.expression.literal.Literal;



public abstract class UnaryExpression extends CompositeExpression{
	private Expression _argument;

	public UnaryExpression(Expression exp){
		_argument = exp;
	}

	public Expression getArgument(){
		return _argument;
	}

	public abstract String getOperator();

	public String getAsText(){
		return "("+ this.getOperator() +" "+ this.getArgument().getAsText() +")";
	}

	
	public abstract Literal accept(ExpressionVisitor visitor);
}