package pex.app.evaluator;

//FIXME import core classes
import pex.core.Program;
import pex.core.Interpreter;
import pex.core.expression.Identifier;
import pt.utl.ist.po.ui.Display;

import java.util.*;

/**
 * Show uninitialized identifiers.
 */
public class ShowUninitializedIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowUninitializedIdentifiers(Program receiver) {
        super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        Display display = new Display();

        Interpreter interpreter = entity().getInterpreter();

        Set<String> setIdentifiers = interpreter.getSetIdentifiers();
        Set<String> setInitialized = interpreter.getSetInitialized();

        for (String element : setInitialized) {
            if (!setIdentifiers.add(element)) {
                setIdentifiers.remove(element);
            }
        }

        for (String element : setIdentifiers) {
            
            display.add( element + "\n");

        }

        display.display();
    }
}
