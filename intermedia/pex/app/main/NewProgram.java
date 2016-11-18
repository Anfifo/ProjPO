package pex.app.main;

//FIXME import used core classes
import pex.app.main.Message

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
        InputString name = new InputString (f, requestProgramId());
        f.parse();

        /* FIXME: Missing treatment for missing program name */
        entity().getInterpreter().addProgram(entity().getInterpreter, name.value());
    }
}
