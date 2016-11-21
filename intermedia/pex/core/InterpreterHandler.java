package pex.core;

import pex.AppIO;


public class InterpreterHandler{
	private Interpreter _interpreter;
	private boolean _initialized; 
	private AppIO _app;


	public InterpreterHandler(AppIO app){
		_initialized = false;
		_app = app;
	}

	public Interpreter getInterpreter(){
		return _interpreter;
	}


	public void newInterpreter(){
		_interpreter = new Interpreter(_app);
		_initialized = true;
	}


	public AppIO getAppIO(){
		return _app;
	}

}