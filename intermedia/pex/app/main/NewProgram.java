package pex.app.main;

/**
 *
 * Command New Program <p>
 * Class responsible for creating an empty new program on the interpreter.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.Program;
import pex.core.Interpreter;
import pex.core.InterpreterHandler;

import pex.app.main.Message;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<InterpreterHandler>{

    /**
     * @param receiver
     */
    public NewProgram(InterpreterHandler receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        Form f = new Form();
        InputString name = new InputString (f, Message.requestProgramId());
        f.parse();

        Program program = new Program (entity().getInterpreter(), name.value());
        entity().getInterpreter().addProgram(program);
        entity().applyChange();
    }
}
