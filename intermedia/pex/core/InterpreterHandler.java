package pex.core;

/**
 * Interpreter Handler Class <p>
 * An Interpreter Handler is the wrapper of Interpreter Class with some added functionalities
 * such as the initialized and changed flag to be able to keep a more in deph track of it's use.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.AppIO;


public class InterpreterHandler{
	/**
	 * The interpreter the handler works as a wrapper for.
	 */
	private Interpreter _interpreter;
	
	/**
	 * a flag that's only true after a interpreter is given to the handler.
	 */
	private boolean _initialized; 

	/**
	 * the app on which the interpreter works under.
	 */
	private AppIO _app;
	
	/**
	 * An InterpreterWrapper can be associated with a Name or a file name.
	 */
	private String _fileName;
	
	/**
	 * A flag that's meant to tracks wether there was a change or not in the program.<p>
	 * This flag is changed by methods and is up to it's user to change it (applyChange) and (saveChange).
	 */
	private boolean _changedFlag;




	/**
	 * Default constructor
	 * @param  app the app it works under
	 */
	public InterpreterHandler(AppIO app){
		_initialized = false;
		_app = app;
		_fileName = null;
		_changedFlag = true;
	}



	/**
	 * returns the Interpreter that the handler is wrapping.
	 * @return the interpreter that the handler is wrapping.
	 */
	public Interpreter getInterpreter(){
		return _interpreter;
	}



	/**
	 * returns the fileName associated to this Handler, it's default value is null.
	 * @return the fileName associated to this Handler.
	 */
	public String getFileName(){
		return _fileName;
	}



	/**
	 * changed the FileName to the given name(String).
	 * @param newFile new FileName to be associated to the interpreter.
	 */
	public void setFileName(String newFile){
		_fileName = newFile;
	}



	/**
	 * Creates a new interpreter to the wrapper with the same app.
	 */
	public void newInterpreter(){
		_interpreter = new Interpreter(_app);
		_initialized = true;
	}




	/**
	 * changed the interpreter's Interpreter to the given new interpreter.
	 * @param interpreter the new interpreter.
	 */
	public void setInterpreter(Interpreter interpreter){
		_interpreter = interpreter;
	}



	/**
	 * returns the App the interpreter is related to.
	 * @return the app the interpreter is related to.
	 */
	public AppIO getAppIO(){
		return _app;
	}



	/**
	 * Function that changes the ChangeFlag to true. Any change of this flag is made mannualy through saveChange and applyChange methods.
	 */
	public void applyChange(){
		_changedFlag = true;
	}



	/**
	 * Function that changes the ChangeFlag to false. Any change of this flag is made mannualy through saveChange and applyChange methods.
	 */
	public void saveChange(){
		_changedFlag = false;
	}



	/**
	 * returns the status of the "changedFlag".
	 * @return the status of the changedFlag.
	 */
	public boolean getChangedStatus(){
		return _changedFlag;
	}

}