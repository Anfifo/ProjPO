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

// File saving imports
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Interpreter implements java.io.Serializable{

	/**
	 * A list of all programs that the interpreter holds.
	 */
	private Map<String, Program> _programList;

	/**
	 * A map/table of all used identifiers in the programs.
	 */
	private Map<String, Identifier> _identifiersMap;

	/**
	 * a map of all initialized identifiers in the running program.
	 */
	private Map<String, Identifier> _initializedIdentifiers;

	/**
	 * the app under which the interpreter works.
	 */
	private AppIO _app;

	/**
	 * flag to keep track of interpreter's saved/unsaved status
	 */
	private boolean _changedFlag;




	/**
	 * default constructor
	 * @param  app app
	 */
	public Interpreter (AppIO app){
		_app = app;
		_programList = new HashMap<String, Program>();
		_identifiersMap = new TreeMap<String, Identifier>();
		_initializedIdentifiers = new TreeMap<String, Identifier>();
		_changedFlag = true;
	}




	/**
	* clones and returns the set of all identifiers
	* @return Set of keys of Identifiers Map ordered alphabetically
	*/
	public Set<String> getIdentifiersSet(){
		return _identifiersMap.keySet();
	}




	/**
	* clones and returns the set of all initialized Identifiers
	* @return Set of keys of initialized Identifiers Map ordered alphabetically
	*/
	public Set<String> getInitializedIdentifiersSet(){
		return _initializedIdentifiers.keySet();
	}



	/**
	 * clears all the current Identifiers structures
	 */
	public void resetIdentifiers(){
		_identifiersMap = new TreeMap<String, Identifier>();
		_initializedIdentifiers = new TreeMap<String, Identifier>();
	}







	/**
	 * Set's Literal value to Identifier id in given Interpreter
	 * @param id    Identifier to which value will be given
	 * @param value value to be given to the Identifier id
	 */
	public void setIdentifierValue(Identifier id, Literal value){
		_changedFlag = true;

		id.setValue(value);

		_identifiersMap.put(id.getAsText(), id);
		_initializedIdentifiers.put(id.getAsText(), id);
	}




	/**
	 * Set's Literal value to Identifier id in given Interpreter
	 * @param id    Identifier to which value will be given
	 * @param value value to be given to the Identifier id
	 */
	public void setUninitializedIdentifier(Identifier id, Literal value){
		_changedFlag = true;

		id.setValue(value);

		_identifiersMap.put(id.getAsText(), id);

	}




	/**
	 * Finds given's Id value
	 * @param  id Identifier which the value belongs to
	 * @return    value of given Indentifier
	 */
	public Literal getIdentifierValue(Identifier id){
		return _identifiersMap.get(id.getAsText()).getValue();
	}





	/**
	 * adds a program to this interpreter
	 * @param program to be added to interpreter
	 */
	public void addProgram(Program program){
		_changedFlag = true;

		if(_programList.containsKey(program.getName()) ){
			_programList.remove(program.getName());
		}
		_programList.put(program.getName(),program);
	}




	/**
	 * finds the Program who's given name belongs to
	 * @param  name name of the program
	 * @return      owner of the name
	 */
	public Program getProgram(String name){
		return _programList.get(name);
	}




	/**
	 * gets the app which the interpreter was created on.
	 * @return the app which the interpreter was created on
	 */
	public AppIO getAppIO(){
		return _app;
	}




	/**
	 * Saves the interpreter into a file with the given name.
	 * In case no change was made to the interpreter since last save
	 * the interpreter won't save.
	 * @param name to be assigned to the file.
	 */
	public void save(String name){
		try{

			if(_changedFlag == false)
				return;

			FileOutputStream fileStream = new FileOutputStream(name);
			ObjectOutputStream out = new ObjectOutputStream(fileStream);

			out.writeObject(this);
			out.close();
			fileStream.close();

			_changedFlag = false;
		}
		catch(IOException io){
			io.printStackTrace();
		}
	}

}
