package pex.core;

public class InterpreterHandler{
	private Interpreter _interpreter;

	public InterpreterHandler(){
		_interpreter = new Interpreter();
	}

	public Interpreter getInterpreter(){
		return _interpreter;
	}

	public void setInterpreter(Interpreter interpreter){
		_interpreter = interpreter;
	}
}