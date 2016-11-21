package pex.core;

import java.util.*;
import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;

public class Program implements java.io.Serializable{
	
	private String _name;

	private Interpreter _interpreter;

	private List<Expression> _expressions;


	/**
	 * Default constructor
	 * @param  interpreter interpreter owner of the program
	 * @param  name program's name
	 */
	public Program(Interpreter interpreter, String name){
		_interpreter = interpreter;
		_expressions = new ArrayList <Expression>();
		_name = name;
	}




	/**
	 * adds to program's expression list the given collection
	 * @param  exp a collection of expressions to be added to the program
	 */
	public void set(Collection <Expression> exp){
		_expressions.addAll(exp);
	}





	/**
	 * adds to index's position in program the given expression
	 * @param idx        program's position index
	 * @param expression expression to be added to given index
	 */
	public void add(int idx, Expression expression){
		_expressions.add(idx, expression);
	}





	/**
	 * replace's program's index position expression with given expression
	 * @param idx        position in program 
	 * @param expression expression that will replace in given idx position
	 */
	public void replace(int idx, Expression expression){
		_expressions.set(idx, expression);
	}




	/**
	 * set's given Identifier to given Literal value
	 * @param id    Identifier's id
	 * @param value that's going to be given to Identifier (id)
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		_interpreter.setIdentifierValue(id, value);
	}




	/**
	 * executes/runs program
	 * @return the literal that results of it's execution
	 */
	public Literal execute(){
		return null; //FIXME needs implementationc
	}




	/**
	 * finds string representation of the Program
	 * @return the string representation of the program
	 */
	public String getAsText(){
		int size = _expressions.size();
		String text = "";

		int i;

		for ( i = 0; i < size; i++){
			text+=_expressions.get(i).getAsText()+"\n";
		}

		return text;
	}




	/**
	 * Finds and returns the program to which the given name belongs to
	 * @param  program's name 
	 * @return      the program which the name belongs to
	 */
	public Program getProgram(String name){

		return _interpreter.getProgram(name);
	}



	/**
	 * returns this program's String name
	 * @return String name
	 */
	public String getProgramName(){
		return _name;
	}
}