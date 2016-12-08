package pex.core;

import java.lang.ClassCastException;

import pex.AppIO;
import pex.core.Program;
import pex.core.Interpreter;
import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;
import pex.core.expression.literal.StringLiteral;
import pex.core.expression.literal.IntegerLiteral;
import pex.core.expression.compositeexpression.*;
import pex.core.expression.compositeexpression.unaryexpression.*;
import pex.core.expression.compositeexpression.binaryexpression.*;
import pex.core.expression.compositeexpression.ternaryexpression.*;
import pex.core.expression.compositeexpression.variadicexpression.*;

public class ExpressionEvaluateVisitor implements ExpressionVisitor{

	public ExpressionEvaluateVisitor(){

	}


	public Literal visit(Add expression) throws BadArgumentException{
		try{
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			return new IntegerLiteral(exp1.intValue() + exp2.intValue());
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(And expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);

			if(exp1.intValue() != 0){
				IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);
				return new IntegerLiteral(exp2.intValue());
			}
			return new IntegerLiteral(0);
		}

		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Div expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return new IntegerLiteral(exp1.intValue()/exp2.intValue());
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Eq expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() == exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Ge expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() >= exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Gt expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() > exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Le expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() <= exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Lt expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() < exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Mod expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return new IntegerLiteral(exp1.intValue() % exp2.intValue());
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Mul expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return new IntegerLiteral (exp1.intValue() * exp2.intValue());
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}





	public Literal visit(Ne expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return exp1.intValue() != exp2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}





	public Literal visit(Or expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return (exp1.intValue() != 0 || exp2.intValue() != 0) ? new IntegerLiteral(1) : new IntegerLiteral(0);
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Set expression) throws BadArgumentException{
		try{
			Identifier id = (Identifier) expression.getFirstArgument();
			Literal value = expression.getSecondArgument().accept(this);
			expression.getInterpreter().setIdentifierValue(id, value);

			return value;
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Sub expression) throws BadArgumentException{
		try{
			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			IntegerLiteral exp2 = (IntegerLiteral)expression.getSecondArgument().accept(this);

			return new IntegerLiteral (exp1.intValue() - exp2.intValue());
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(While expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral) expression.getFirstArgument().accept(this);

			while(exp1.intValue() != 0){
				expression.getFirstArgument().accept(this);
				exp1 = (IntegerLiteral) expression.getSecondArgument().accept(this);
			}
			return new IntegerLiteral(0);
		}

		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}





	public Literal visit(If expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral)expression.getFirstArgument().accept(this);
			Literal exp2;

			if(exp1.intValue() != 0)
				exp2 = expression.getSecondArgument().accept(this);
			else
				exp2 = expression.getThirdArgument().accept(this);

			return exp2;
		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Call expression) throws BadArgumentException{
		try{

			StringLiteral name = (StringLiteral)expression.getArgument().accept(this);
			Program program = expression.getInterpreter().getProgram(name.stringValue());

			return program.execute();

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}





	public Literal visit(Neg expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral) expression.getArgument().accept(this);
			return new IntegerLiteral(0 - exp1.intValue());

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}





	public Literal visit(Not expression) throws BadArgumentException{
		try{

			IntegerLiteral exp1 = (IntegerLiteral) expression.getArgument().accept(this);

			return (exp1.intValue() == 0) ? new IntegerLiteral(1) : new IntegerLiteral(0);

		}
		catch(ClassCastException cce){
			throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
		}
	}




	public Literal visit(Print expression) throws BadArgumentException{
		AppIO app = expression.getAppIO();

		Literal value = new IntegerLiteral(0);

		for(Expression exp : expression.getArguments()){
			value = exp.accept(this);
			try{
				app.println( ((IntegerLiteral)value).getAsText() );
			}

			catch(ClassCastException cce){
				try{
					app.println( ((StringLiteral)value).stringValue() );
				}
				catch(ClassCastException cce2){
					throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
				}
			}
		}
		return value;
	}




	public Literal visit(Seq expression) {
		Literal value = new IntegerLiteral(0);

		for(Expression exp : expression.getArguments())
			value = exp.accept(this);
		return value;
	}





	public Literal visit(ReadI expression) {
		return new IntegerLiteral(expression.getAppIO().readInteger());
	}





	public Literal visit(ReadS expression) {
		return new StringLiteral(expression.getAppIO().readString());
	}





	public Literal visit(Identifier expression) {

		Literal value = expression.getInterpreter().getIdentifierValue(expression);
		if(value != null)
			return value;
		else
			return new IntegerLiteral(0);

	}





	public Literal visit(IntegerLiteral expression) {
		return expression;

	}




	public Literal visit(StringLiteral expression) throws BadArgumentException{
		return expression;

	}
}
