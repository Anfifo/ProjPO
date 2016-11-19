package pex.core;

/**
 * Fancy class name and description placeholder
 */

import pex.AppIO;
import pex.core.Program;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;



public class Interpreter{
	private List<Program> _programList;
	
	private List<Identifier> _identifierList;
	
	private AppIO _app;
	
	private int _programCounter;

	/**
	 * default constructor
	 * @param  app app
	 */
	public Interpreter (AppIO app){
		_app = app;
		_programList = new ArrayList<>();
		_identifierList = new ArrayList<>();
		_programCounter = 0;
	}


	private Identifier getIdentifier(Identifier id){
		int size = _identifierList.size();

		for ( i = 0; i < size ; i++){
			if( _identifierList.get(i).equals(id))
				return _identifierList.get(i);
		}
	}

	/**
	 * Set's Literal value to Identifier id in given Interpreter 
	 * @param id    Identifier to which value will be given
	 * @param value value to be given to the Identifier id
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		int size = _identifierList.size();

		for ( i = 0; i < size ; i++){
			if( _identifierList.get(i).equals(id))
				_identifierList.setIdentifierValue(value);
		}		
	}




	/**
	 * Finds given's Id value
	 * @param  id Identifier which the value belongs to
	 * @return    value of given Indentifier
	 */
	public Literal getIdentifierValue(Identifier id){
		return getIdentifier(id).getIdentifierValue();
	}





	/**
	 * adds a program to this interpreter
	 * @param program to be added to interpreter
	 */
	public void addProgram(Program program){
		_programList.add(program);
		_programCounter++;
	}





	/**
	 * finds the Program who's given name belongs to
	 * @param  name name of the program
	 * @return      owner of the name
	 */
	public Program getProgram(String name){
		int i;

		for ( i = 0; i < _programCounter ; i++)
			if (name.equals(_programList.get(i).getProgramName())
				return _programList.get(i);

		return null;
	}





	/**
	 * gets the app which the interpreter was created on
	 * @return the app which the interpreter was created on
	 */
	public AppIO getAppIO(){
		return _app;
	}

}