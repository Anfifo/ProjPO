package pex.core;

import pex.core.expression.literal.*;
import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.compositeexpression.*;
import pex.core.expression.compositeexpression.unaryexpression.*;
import pex.core.expression.compositeexpression.binaryexpression.*;
import pex.core.expression.compositeexpression.ternaryexpression.*;
import pex.core.expression.compositeexpression.variadicexpression.*;

public class ExpressionEvaluateVisitor implements ExpressionVisitor{

	public ExpressionEvaluateVisitor(){

	}

	public Literal visit(Add expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);
		return new IntegerLiteral(exp1.intValue() + exp2.intValue());
	}

	public Literal visit(And expression){

		return null;
	}

	public Literal visit(Div expression){

		return null;
	}

	public Literal visit(Eq expression){

		return null;
	}

	public Literal visit(Ge expression){
		return null;

	}

	public Literal visit(Gt expression){
		return null;

	}

	public Literal visit(Le expression){
		return null;

	}

	public Literal visit(Lt expression){
		return null;

	}

	public Literal visit(Mod expression){
		return null;

	}

	public Literal visit(Mul expression){
		return null;

	}

	public Literal visit(Ne expression){
		return null;

	}

	public Literal visit(Or expression){
		return null;

	}

	public Literal visit(Set expression){
		return null;

	}

	public Literal visit(Sub expression){
		return null;

	}

	public Literal visit(While expression){
		return null;

	}

	public Literal visit(If expression){
		return null;

	}

	public Literal visit(Call expression){
		return null;

	}

	public Literal visit(Neg expression){
		return null;

	}

	public Literal visit(Not expression){
		return null;

	}

	public Literal visit(Print expression){
		return null;

	}

	public Literal visit(Seq expression){
		return null;

	}

	public Literal visit(ReadI expression){
		return null;

	}

	public Literal visit(ReadS expression){
		return null;

	}

	public Literal visit(Identifier expression){
		return null;

	}

	public Literal visit(IntegerLiteral expression){
		return expression;

	}

	public Literal visit(StringLiteral expression){
		return null;

	}

}
