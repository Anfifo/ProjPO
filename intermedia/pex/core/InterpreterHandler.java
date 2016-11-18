package pex.core;

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


	public void setInterpreter(Interpreter interpreter){
		_interpreter = interpreter;
		_initialized = true;
	}


	public AppIO getAppIO(){
		return _app;
	}

}