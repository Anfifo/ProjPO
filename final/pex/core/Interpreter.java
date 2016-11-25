package pex.core;

/**
 * Interpreter Class <p>
 * An interpreter is a computer program that directly executes expressions written in a programming language, without previously compiling them.<p>
 * An interpreter can hold 0 or more programs and is able to access and change them.<p>
 * An interpreter has a list of all identifiers (variables) used in it's programs with it's values associated and is able to access them.<p>
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Interpreter_(computing)">Interpreter(Computing) at Wikipedia</a>
 */

import pex.AppIO;
import pex.core.Program;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;

import java.util.*;


public class Interpreter implements java.io.Serializable{

	/**
	 * A list of all programs that the interpreter holds.
	 */
	private List<Program> _programList;
	
	/**
	 * A map/table of all used identifiers in the programs.
	 */
	private Map<String, Identifier> _identifiersMap;
	
	/**
	 * the app under which the interpreter works.
	 */
	private AppIO _app;
	



	/**
	 * default constructor
	 * @param  app app
	 */
	public Interpreter (AppIO app){
		_app = app;
		_programList = new ArrayList<>();
		_identifiersMap = new HashMap<String, Identifier>();
	}





	/**
	 * Set's Literal value to Identifier id in given Interpreter 
	 * @param id    Identifier to which value will be given
	 * @param value value to be given to the Identifier id
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		if(_identifiersMap.get(id.getAsText()) == null)
			_identifiersMap.put(id.getAsText(), id);
		
		_identifiersMap.get(id.getAsText()).setIdentifierValue(value);
	}	




	/**
	 * Finds given's Id value
	 * @param  id Identifier which the value belongs to
	 * @return    value of given Indentifier
	 */
	public Literal getIdentifierValue(Identifier id){
		return _identifiersMap.get(id.getAsText()).getIdentifierValue();
	}





	/**
	 * adds a program to this interpreter
	 * @param program to be added to interpreter
	 */
	public void addProgram(Program program){
		int i;
		int programCounter = _programList.size();

		for ( i = 0; i < programCounter ; i++)
			if (program.getProgramName().equals(_programList.get(i).getProgramName())){
				_programList.set(i, program);
				return;
			}
		
		_programList.add(program);
	}




	/**
	 * finds the Program who's given name belongs to
	 * @param  name name of the program
	 * @return      owner of the name
	 */
	public Program getProgram(String name){
		int i;
		int programCounter = _programList.size();
		for ( i = 0; i < programCounter ; i++)
			if (name.equals(_programList.get(i).getProgramName()))
				return _programList.get(i);

		return null;
	}





	/**
	 * gets the app which the interpreter was created on.
	 * @return the app which the interpreter was created on
	 */
	public AppIO getAppIO(){
		return _app;
	}

}