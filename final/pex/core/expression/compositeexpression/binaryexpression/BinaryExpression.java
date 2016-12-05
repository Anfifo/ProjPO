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
import pex.core.ExpressionVisitor;
import pex.core.expression.literal.Literal;



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

	public String getAsText(){
		return "("+ this.getOperator() + " "+ this.getFirstArgument().getAsText() + " " +  this.getSecondArgument().getAsText() +")";
	}

	public abstract String getOperator();


	public abstract Literal accept(ExpressionVisitor visitor);
}