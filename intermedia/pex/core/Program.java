package pex.core;

/**
 * Program Class <p>
 * Representation of a program: a program is a series of coded expressions.<p>
 * A program has a name and the interpreter which it is related to.<p>
 * A program is able to execute and edit it's expressions.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Computer_program">Computer Program at Wikipedia</a>
 */

/* including java Lists and Collections*/
import java.util.*;

import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;

public class Program implements java.io.Serializable{
	
	/**
	 * A program's name is unique to a program, there can't be 2 programs with same name.
	 */
	private String _name;

	/**
	 * The interpreter to which the program is related to. A program has only one interpreter.
	 */
	private Interpreter _interpreter;

	/**
	 * A program's code is represented/composed by a group of expressions.
	 */
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
	 * Adds to program's expression list the given collection of expressions.
	 * @param  exp a collection of expressions to be added to the program.
	 */
	public void set(Collection <Expression> exp){
		_expressions.addAll(exp);
	}





	/**
	 * Adds to index's position in program the given expression.
	 * @param idx        program's position index.
	 * @param expression expression to be added to given index.
	 */
	public void add(int idx, Expression expression){
		_expressions.add(idx, expression);
	}





	/**
	 * Replace's program's index position expression with given expression.
	 * @param idx        position in program.
	 * @param expression expression that will replace in given idx position.
	 */
	public void replace(int idx, Expression expression){
		_expressions.set(idx, expression);
	}




	/**
	 * Set's given Identifier's value to given value.
	 * @param id    Identifier.
	 * @param value that's going to be given to the Identifier (id)
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		_interpreter.setIdentifierValue(id, value);
	}




	/**
	 * executes/runs program's code/expressions.
	 * @return the literal that results of it's execution.
	 */
	public Literal execute(){
		return null; //FIXME needs implementationc
	}




	/**
	 * Finds string representation of the Program's code.
	 * @return the string representation of the program.
	 */
	public String getAsText(){
		int size = _expressions.size();
		String text = "";
		int i;

		for ( i = 0; i < size; i++)
			text+=_expressions.get(i).getAsText()+"\n";

		return text;
	}




	/**
	 * Finds and returns the program to which the given name belongs to.
	 * @param  program's name.
	 * @return      the program which the name belongs to.
	 */
	public Program getProgram(String name){

		return _interpreter.getProgram(name);
	}



	/**
	 * Returns this program's String name which is unique to each program.
	 * @return String name
	 */
	public String getProgramName(){
		return _name;
	}
}