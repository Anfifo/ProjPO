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

// File saving imports
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;



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
	 * Default constructor
	 * @param  app the app it works under
	 */
	public InterpreterHandler(AppIO app){
		_initialized = false;
		_app = app;
		_fileName = null;
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
	 * saves the Interpreter to the file the Handler is associated to
	 * @throws NullPointerException if no file is associated to handler
	 */
	public void saveInterpreter() throws NullPointerException{
		if(_fileName == null)
			throw new NullPointerException();

		_interpreter.save(this.getFileName());
	}



	/**
	 * Saves the Interpreter in a file with the given name
	 * at the same time associates the Handler to this (file)name given.
	 * @param name [description]
	 */
	public void saveInterpreter(String name){
		this.setFileName(name);
		this.saveInterpreter();
	}





	/**
	 * Loads a new interpreter into the Handler in the given file's name
	 * @param  name                  name of the file with an interpreter saved
	 * @throws NullPointerException  if no file exists with such name
	 * @throws FileNotFoundException if file wasn't found
	 */
	public void openInterpreter(String name) throws NullPointerException, FileNotFoundException{
		try{
			File file = new File(name);

			if (file.exists()) {

				FileInputStream fileStream = new FileInputStream(name);
				ObjectInputStream in = new ObjectInputStream(fileStream);
				
				Interpreter interpreter = (Interpreter) in.readObject();

				_interpreter = interpreter;

				_fileName = name;

				in.close();
				fileStream.close();
			}
			else
				throw new NullPointerException();
		}
		catch(FileNotFoundException f){
            throw f;
        }
        catch(ClassNotFoundException o){
            o.printStackTrace();
        }
        catch(IOException io){
            io.printStackTrace();
        }
	}
}