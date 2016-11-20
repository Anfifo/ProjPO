package pex.core.expression.compositeexpression.variadicexpression;

import pex.core.expression.literal;

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
		
		int i = 0;

		String output = "(print ";


		for( i = 0; i < size-1; i++){
			output += expressions.get(i).getAsText() + " ";
		}

		output += expression.get(i+1).getAsText()+ ")";
 
		return output;
	}




	/**
	 * returns the literal that represents the Expression
	 * @return the literal representation of the expression
	 */
	public Literal evaluate(){
	}
}