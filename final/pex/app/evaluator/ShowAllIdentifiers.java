package pex.app.evaluator;

//FIXME import core classes
import pex.core.Program;
import pex.core.Interpreter;
import pex.core.expression.Identifier;
import pt.utl.ist.po.ui.Display;

import java.util.*;

/**
 * Show all program identifiers.
 */
public class ShowAllIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowAllIdentifiers(Program receiver) {
        super(Label.SHOW_ALL_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        Display display = new Display();

        for (String element : entity().getIdentifiers()) {
            display.add( element + "\n");
        }

        display.display();
    }
}
