package pex.app.main;

import pex.core.InterpreterHandler;
import pex.core.Interpreter;
import pex.core.Program;

import pex.app.main.Message;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
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
    }
}
