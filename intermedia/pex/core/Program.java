package pex.core;

public class Program{
	private String _name;

	private InterpreterHandle _interpreter;

	private List<Expression> _expressions;

	/**
	 * Default constructor
	 * @param  interpreter interpreter owner of the program
	 * @param  name program's name
	 */
	public Program(Interpreter interpreter, String name){
		_interpreter = interpreter;
		_expression = new ArrayList <Expression>();
		_name = name;
	}




	/**
	 * adds to index's position in program the given expression
	 * @param idx        program's position index
	 * @param expression expression to be added to given index
	 */
	public void add(int idx, Expression expression){
		expressions.add(idx, expression);
	}





	/**
	 * replace's program's index position expression with given expression
	 * @param idx        position in program 
	 * @param expression expression that will replace in given idx position
	 */
	public void replace(int idx, Expression expression){
		expressions.set(idx, expression);
	}




	/**
	 * set's given Identifier to given Literal value
	 * @param id    Identifier's id
	 * @param value that's going to be given to Identifier (id)
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		_interpreter.getInterpreter().setIdentifierValue(id, value);
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
		int size = _expressions.size();

		int i;

		for ( i = 0; i < size; i++){
			_expressions.getAsText();
		}
	}




	/**
	 * Finds and returns the program to which the given name belongs to
	 * @param  program's name 
	 * @return      the program which the name belongs to
	 */
	public Program getProgram(String name){

		return _interpreter.getInterpreter().getProgram(name);
	}


	public String getProgramName(){
		return _name;
	}
}