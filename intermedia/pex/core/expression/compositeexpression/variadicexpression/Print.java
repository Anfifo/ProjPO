package pex.core.expression.compositeexpression.variadicexpression;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import pex.core.expression.Expression;

import java.util.*;


public class Print extends VariadicExpression{

	/**
	 * default Constructor
	 * @param  exp1 List with all "arguments"
	 */
	public Print(List <Expression> expressions){
		super(expressions);
	}




	/**
	 * creates and returns the string representation of the class
	 * @return the string representation
	 */
	public String getAsText(){
 		List<Expression> expressions = super.getArguments();
		
		int size = expressions.size();
		
		int i;

		String output = "(print";

		for( i = 0; i < size; i++){
			output += " " + expressions.get(i).getAsText();
		}
		output += ")";
 
		return output;
	}




	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
		return null; //FIXME needs implementation
	}
}