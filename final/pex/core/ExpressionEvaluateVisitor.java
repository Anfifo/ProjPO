package pex.core;

import java.lang.ClassCastException;

import pex.AppIO;
import pex.core.Program;
import pex.core.Interpreter;
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

	/**
	 * Evaluates an Add expression if it's arguments are valid
	 * @param  Add                  expression    the expression that represents Add
	 * @return                      the sum of both arguments/expresisons composing the Add
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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



	/**
	 * Evaluates an And expression if it's arguments are valid
	 * Evaluate to IntegerLiteral 1 if both arguments are diffferent from 0 or IntegerLiteral 0 if one at least one is 0
	 * In case first Argument is equal to IntegerLiteral 0 the second argument won't be evaluated
	 * @param  And                  expression    the expression that represents and
	 * @return                      if first argument composing And has int value != 0 returns the evaluation of the second argument
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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



	/**
	 * Evaluates Division expression if it's arguments are valid
	 * Divides Div's first argument by Div's second argument returning an int value
	 * @param  Div                  expression    the Div expression
	 * @return                      the divison of Div's first argument by Div's second argument
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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



	/**
	 * Evaluates Equal expression if it's arguments are valid
	 * compares Eq's first argument with Eq's second argument returns 1 if they have equal values
	 * @param  Eq                   expression    Eq's expression containing 2 argument expression
	 * @return                      IntegerLiteral 1 if both arguments are equal else IntegerLiteral 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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




	/**
	 * Evaluates GreaterOrEqual expression if it's arguments are valid
	 * compares Ge's arguments, returning IntegerLiteral 1 if first is greater or equal than the second
	 * @param  Ge                   expression    Ge's expression containing 2 argument expressions
	 * @return                      IntegerLiteral 1 if first argument is greater or equal than second, else IntegerLiteral 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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



	/**
	 * Evaluates GreaterThan expression if it's arguments are valid
	 * compare Gt's arguments, returning IntegerLiteral if first argument is greater than the second
	 * @param  Gt                   expression    the Gt's expression containing 2 arguments expression
	 * @return                      IntegerLiteral 1 if first argument is greater or qual than second, else IntegerLiteral 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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



	/**
	 * Evaluates LesserThanOrEqual expression if it's arguments are valid
	 * compare Le's arguments, returning IntegerLiteral if first argument is lesser or equal than the second
	 * @param  Le                   expression    the Le's expression containing 2 arguments expression
	 * @return                      IntegerLiteral 1 if first argument is less than or equal to second argument, else Integer 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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




	/**
	 * Evaluates LesserThan expression if it's arguments are valid
	 * compare Lt's arguments, returning IntegerLiteral if first arguement value is lesser than the second
	 * @param  Lt                   expression    the Lt's expression containing 2 arguments expression
	 * @return                      IntegerLiteral 1 if first argument is lesser than the second argument, else Integer 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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




	/**
	 * Evaluates Mod expression if it's arguments are valid
	 * returns the mod of Mod's first argument and second argument
	 * @param  Mod                  expression    the Mod expression containing 2 arguments expression
	 * @return                      the IntegerLiteral with the value of the mod between the 2 arguments
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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




	/**
	 * Evaluates Multiplication expresison if it's arguments are valid
	 * returns the multiplication of Mul's first argument and Mul's second argument
	 * @param  Mul                  expression   the Mul expression containing 2 arguments expression
	 * @return                      the IntegerLiteral with the value of first argument's value multiplied by the second argument's value
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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





	/**
	 * Evaluates NotEqual expression if it's arguments are valid
	 * compares Ne's first expression with Ne's second expression value and returns zero IntegerLiteral if they're equal
	 * @param  Ne                   expression    the Ne expression containing 2 arguments expression
	 * @return                      IntegerLiteral 1 if first argument's value is different from second argument value, else IntegerLiteral 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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





	/**
	 * Evaluates Or expression if it's arguments are valid
	 * checks Or's 2 arguments and returns IntegerLiteral (1) if at least one of them is different from 0
	 * @param  Or                   expression    the Or expression containing 2 arguments expression
	 * @return                      IntegerLiteral 1 if at least one of the arguments is different from 0, and 0 if both are 0
	 * @throws BadArgumentException in case one of the arguments isn't valid(cast-able to IntegerLiteral)
	 */
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




	/**
	 * Evaluates Set expression if it's arguments are valid
	 * set's to Identifier(Set's first argument) value to the given Literal (Set's Second argument)
	 * @param  Set                  expression    the Set expression containing 2 argument expression
	 * @return                      the value of the Set's second argument evaluation
	 * @throws BadArgumentException
	 */
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
		String output = "";

		for(Expression exp : expression.getArguments()){
			value = exp.accept(this);
			try{
				output+=((IntegerLiteral)value).getAsText();
			}

			catch(ClassCastException cce){
				try{
					output+=((StringLiteral)value).stringValue();
				}
				catch(ClassCastException cce2){
					throw new BadArgumentException("Invalid Arguments for" + expression.getOperator() + " operator");
				}
			}
		}
		app.println(output);
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
