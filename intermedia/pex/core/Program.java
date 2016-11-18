package pex.core;

public class Program{
	private String _name;

	private List<Identifier> _indentifiers;




	/**
	 * adds to index's position in program the given expression
	 * @param idx        program's position index
	 * @param expression expression to be added to given index
	 */
	public void add(int idx, Expression expression){

	}





	/**
	 * replace's program's index position expression with given expression
	 * @param idx        position in program 
	 * @param expression expression that will replace in given idx position
	 */
	public void replace(int idx, Expression expression){

	}




	/**
	 * set's given Identifier to given Literal value
	 * @param id    Identifier's id
	 * @param value that's going to be given to Identifier (id)
	 */
	public void setIdentifierValue(Identifier id, Literal value){

	}




	/**
	 * executes/runs program
	 * @return the literal that results of it's execution
	 */
	public Literal execute(){

	}




	/**
	 * finds string representation of the Program
	 * @return the string representation of the program
	 */
	public String getAsText(){

	}




	/**
	 * Finds and returns the program to which the given name belongs to
	 * @param  program's name 
	 * @return      the program which the name belongs to
	 */
	public Program getProgram(String name){

	}


}