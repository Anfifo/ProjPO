package pex.core.expression;

import pex.core.expression.literal;

public class Identifier extends Expression{
	private String _name;

	private Literal _value;
	
	private boolean _initialized;

	public Identifier(String name){
		_name = name;
		_initialized = false;
		// Literal = 0 ?
	}

	public Identifier(String name, Literal value){
		_name = name;
		_value = value;
		_initialized = true;
	}



	public setIdentifierValue(Literal value){
		_value = value;
		_initialized = true;
	}

	public String getAsText(){
		return _name;
	}

	public Literal evaluate(){

	}


	public equals(Object object){

	    if (object instanceof Identifier) {
	        Identifier object = (Identifier) object;
	        return object.getAsText().equals(this.getAsText());
    	}
    	
    	return false;
	}


}