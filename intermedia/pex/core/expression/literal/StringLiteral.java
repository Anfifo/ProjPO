package pex.core.expression.literal;


public class StringLiteral extends Literal{
	String _value;


	public StringLiteral(String value){
		_value = value;
	}

	public String getAsText(){
		return "\""+ _value +"\""; 
	}

	public String stringValue(){
		return _value;
	}

	public Literal evaluate(){
		return this;
	}
}