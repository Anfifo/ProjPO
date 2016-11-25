package pex.core.expression.literal;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

public class IntegerLiteral extends Literal{
	private int _value;

	public IntegerLiteral(int value){
		_value = value;
	}

	public String getAsText(){
		return ""+_value;
	}

	public int intValue(){
		return _value;
	}

	public Literal evaluate(){
		return this;
	}

}