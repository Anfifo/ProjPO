package pex.core;

import java.lang.ClassCastException;

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
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);

		if(exp1.intValue() != 0){
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);
			return new IntegerLiteral(exp2.intValue());
		}

		return new IntegerLiteral(0);
	}




	public Literal visit(Div expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return new IntegerLiteral(exp1.intValue()/exp2.intValue());
	}




	public Literal visit(Eq expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() == exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Ge expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() >= exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Gt expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() > exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Le expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() <= exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Lt expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() < exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Mod expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return new IntegerLiteral(exp1.intValue() % exp2.intValue());
	}




	public Literal visit(Mul expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return new IntegerLiteral (exp1.intValue() * exp2.intValue());
	}





	public Literal visit(Ne expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return exp1.intValue() != exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}





	public Literal visit(Or expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return (exp1.intValue() != 0 || exp2.intValue() != 0) ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}




	public Literal visit(Set expression){
		return null;
	}




	public Literal visit(Sub expression){
		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

		return new IntegerLiteral (exp1.intValue() - exp2.intValue());
	}




	public Literal visit(While expression){
		IntegerLiteral exp1 = (IntegerLiteral) expression.getFirstArgument().accept(this);

		while(exp1.intValue() != 0){
			expression.getFirstArgument().accept(this);
			exp1 = (IntegerLiteral) expression.getSecondArgument().accept(this);
		}
		return new IntegerLiteral(0);
	}




	public Literal visit(If expression){

		IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
		Literal exp2;

		if(exp1.intValue() == 0)
			exp2 = expression.getSecondArgument().accept(this);
		else
			exp2 = expression.getThirdArgument().accept(this);

		return exp2;
	}




	public Literal visit(Call expression){
		return null;

	}




	public Literal visit(Neg expression){
		IntegerLiteral exp1 = (IntegerLiteral) expression.getArgument().accept(this);

		return new IntegerLiteral(0 - exp1.intValue());
	}




	public Literal visit(Not expression){
		IntegerLiteral exp1 = (IntegerLiteral) expression.getArgument().accept(this);

		return (exp1.intValue() == 0) ? new IntegerLiteral(1) : new IntegerLiteral(0);
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
