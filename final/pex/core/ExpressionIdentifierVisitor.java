package pex.core;

import java.util.List;

import pex.core.expression.literal.*;
import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.compositeexpression.*;
import pex.core.expression.compositeexpression.unaryexpression.*;
import pex.core.expression.compositeexpression.binaryexpression.*;
import pex.core.expression.compositeexpression.ternaryexpression.*;
import pex.core.expression.compositeexpression.variadicexpression.*;

public class ExpressionIdentifierVisitor implements ExpressionVisitor{

		private Interpreter _interpreter;


	public ExpressionIdentifierVisitor(Interpreter interpretador){

		_interpreter = interpretador;

	}


	public Literal visit(Add expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(And expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;
	}

	public Literal visit(Div expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;
	}

	public Literal visit(Eq expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;
	}

	public Literal visit(Ge expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Gt expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Le expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Lt expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Mod expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Mul expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Ne expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Or expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(Set expression){



		_interpreter.setIdentifierValue( (Identifier) expression.getFirstArgument(), null);
		expression.getSecondArgument().accept(this);
		
		return null;

	}

	public Literal visit(Sub expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(While expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);

		return null;

	}

	public Literal visit(If expression){

		expression.getFirstArgument().accept(this);
		expression.getSecondArgument().accept(this);
		expression.getThirdArgument().accept(this);

		return null;

	}

	public Literal visit(Call expression){

		expression.getArgument().accept(this);

		return null;

	}

	public Literal visit(Neg expression){

		expression.getArgument().accept(this);

		return null;

	}

	public Literal visit(Not expression){

		expression.getArgument().accept(this);

		return null;

	}

	public Literal visit(Print expression){

		List<Expression> exps = expression.getArguments();

		for (Expression expressao : exps) {
			expressao.accept(this);
		}

		return null;

	}

	public Literal visit(Seq expression){

		List<Expression> exps = expression.getArguments();

		for (Expression expressao : exps) {
			expressao.accept(this);
		}

		return null;

	}

	public Literal visit(ReadI expression){
		return null;

	}

	public Literal visit(ReadS expression){
		return null;

	}

	public Literal visit(Identifier expression){

		_interpreter.setUninitializedIdentifier(expression);

		return null;

	}

	public Literal visit(IntegerLiteral expression){
		return null;

	}

	public Literal visit(StringLiteral expression){
		return null;

	}

}
