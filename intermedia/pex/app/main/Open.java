package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

//FIXME import used core classes
import pex.core.InterpreterHandler;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Open existing interpreter.
 */
public class Open extends Command<InterpreterHandler> {
    /**
     * @param receiver
     */
    public Open(InterpreterHandler receiver) {
        super(Label.OPEN, receiver);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        //FIXME implement
    }
}
