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
	 * flag to keep track whether the identifier has an value associated or not.
	 */
	private boolean _initialized;




	/**
	 * Constructor with only name.
	 * @param  name to be associated to this identifier
	 */
	public Identifier(String name){
		_name = name;
		_initialized = false;
		// missing default initialization of Literal value
	}




	/**
	 * Constructor with name and value.
	 * @param  name  to be associated to this identifier.
	 * @param  value to be given to this identifier.
	 */
	public Identifier(String name, Literal value){
		_name = name;
		_value = value;
		_initialized = true;
	}




	/**
	 * returns the value the identifier represents.
	 * @return the value the identifier represents.
	 */
	public Literal getIdentifierValue(){
		return _value;
	}



	/**
	 * changed the value of the identifier holds/represents.
	 * @param value the new value to be associated to the identifier.
	 */
	public void setIdentifierValue(Literal value){
		_value = value;
		_initialized = true;
	}



	/**
	 * returns the String name that represents the identifier.
	 * @return the name the identifier is represented by.
	 */
	public String getAsText(){
		return _name;
	}



	/**
	 * Evaluates the Identifier returning it's value.
	 * @return the result of it's evaluation.
	 */
	public Literal evaluate(){
		return _value; //FIXME might not be proper implemented
	}




	/**
	 * compares given object to this identifier, identifiers are equal if they have the same name.
	 * @param  object object to be compared to
	 * @return        true if they're equal, false if they're different or object is not of instance Identifier.
	 */
	public boolean equals(Object object){

	    if (object instanceof Identifier) {
	        Identifier that = (Identifier) object;
	        return that.getAsText().equals(this.getAsText());
    	}
    	
    	return false;
	}


}