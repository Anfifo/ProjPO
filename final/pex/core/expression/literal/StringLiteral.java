package pex.core.expression.literal;

/**
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */


import pex.core.ExpressionVisitor;



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
	
	public Literal accept(ExpressionVisitor visitor){
		return visitor.visit(this);
	}
}