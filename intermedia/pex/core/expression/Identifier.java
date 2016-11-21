package pex.core.expression;

import pex.core.expression.literal.Literal;
import java.util.*;

public class Identifier extends Expression{
	private String _name;

	private Literal _value;
	
	private boolean _initialized;

	public Identifier(String name){
		_name = name;
		_initialized = false;
		// missing default initialization of Literal value
	}

	public Identifier(String name, Literal value){
		_name = name;
		_value = value;
		_initialized = true;
	}

	public Literal getIdentifierValue(){
		return _value;
	}

	public void setIdentifierValue(Literal value){
		_value = value;
		_initialized = true;
	}

	public String getAsText(){
		return _name;
	}

	public Literal evaluate(){
		return null; //FIXME needs implementation
	}


	public boolean equals(Object object){

	    if (object instanceof Identifier) {
	        Identifier that = (Identifier) object;
	        return that.getAsText().equals(this.getAsText());
    	}
    	
    	return false;
	}


}