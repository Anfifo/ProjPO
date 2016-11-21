package pex.core;

import pex.AppIO;


public class InterpreterHandler{
	private Interpreter _interpreter;
	
	private boolean _initialized; 
	
	private AppIO _app;
	
	private String _fileName;
	
	private boolean _changedFlag;


	public InterpreterHandler(AppIO app){
		_initialized = false;
		_app = app;
		_fileName = null;
		_changedFlag = true;
	}

	public Interpreter getInterpreter(){
		return _interpreter;
	}

	public String getFileName(){
		return _fileName;
	}

	public void setFileName(String newFile){
		_fileName = newFile;
	}

	public void newInterpreter(){
		_interpreter = new Interpreter(_app);
		_initialized = true;
	}

	public void setInterpreter(Interpreter interpreter){
		_interpreter = interpreter;
	}

	public AppIO getAppIO(){
		return _app;
	}

	public void applyChange(){
		_changedFlag = true;
	}

	public void saveChange(){
		_changedFlag = false;
	}

	public boolean getChangedStatus(){
		return _changedFlag;
	}

}