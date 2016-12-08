package pex.core.expression;

/**
 * Identifier Class<p>
 * An identifier represents a pair of name and value. It associates a Literal value to an Id.
 *
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.expression.literal.Literal;
import java.util.*;
import pex.core.ExpressionVisitor;
import pex.core.Interpreter;


public class Identifier extends Expression{
	/**
	 * the name/representation of the expression
	 */
	private String _name;



	/**
	 * the value held by this identifier. FIXME:Undefined when not initialized?
	 */
	private Literal _value;



	/**
	 * interpreter used to access the current identifiers list
	 */
	private Interpreter _interpreter;



	/**
	 * Constructor with only name.
	 * @param  name to be associated to this identifier
	 */
	public Identifier(String name){
		_name = name;
		// missing default initialization of Literal value
	}


	/**
	 * constructor with interpreter
	 * @param  String      name          Identifier's unique ID
	 * @param  Interpreter interpreter   the interpreter which the identifier is linked to
	 */
	public Identifier(String name, Interpreter interpreter){
		_name = name;
		_interpreter = interpreter;
	}

	/**
	 * returns the identifier attribute
	 * @return the identifier
	 */
	public Interpreter getInterpreter(){
		return _interpreter;
	}


	/**
	 * Constructor with name and value.
	 * @param  name  to be associated to this identifier.
	 * @param  value to be given to this identifier.
	 */
	public Identifier(String name, Literal value){
		_name = name;
		_value = value;
	}




	/**
	 * returns the value the identifier represents.
	 * @return the value the identifier represents.
	 */
	public Literal getValue(){
		return _value;
	}



	/**
	 * changed the value of the identifier holds/represents.
	 * @param value the new value to be associated to the identifier.
	 */
	public void setValue(Literal value){
		_value = value;
	}



	/**
	 * returns the String name that represents the identifier.
	 * @return the name the identifier is represented by.
	 */
	public String getAsText(){
		return _name;
	}



	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}

}
