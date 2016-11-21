package pex.app.evaluator;

/**
 * Show Program <p>
 * Class (command) responsible for listing to the output the given program's code.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import pex.core.Program;
import pt.utl.ist.po.ui.Display;


/**
 * Show program (present code).
 */
public class ShowProgram extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowProgram(Program receiver) {
        super(Label.SHOW_PROGRAM, receiver);
    }


    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        String programString = entity().getAsText();

        Display display = new Display();

        display.add(programString);
        
        display.display();
    }
}
