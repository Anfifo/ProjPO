package pex.core.expression.literal;


public class IntegerLiteral extends Literal{
	private int _value;

	public IntegerLiteral(int value){
		_value = value;
	}

	public String getAsText(){
		return "\"" + _value + "\"";
	}

	public int intValue(){
		return _value;
	}

	public Literal evaluate(){
		return this;
	}

}