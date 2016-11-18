package pex.app.main;


import pex.core.Interpreter;
import pex.core.InterpreterHandler;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;

/**
 * Command for creating a new interpreter.
 */
public class New extends Command<InterpreterHandler> {
    /**
     * @param receiver
     */
    public New(InterpreterHandler receiver) {
        super(Label.NEW, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        entity().setInterpreter(entity().getAppIO());
    }
}
