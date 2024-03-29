package pex.app.main;

/**
 *  Class Edit Program <p>
 *  Responsible for selecting a program (through user input)
 *  and calling upon the program it's editing menu.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 * 
 */

import pex.core.Program;
import pex.core.Interpreter;
import pex.core.InterpreterHandler;


import pex.app.main.Message;
import pex.app.evaluator.EvaluatorMenu;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputString;


/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<InterpreterHandler> {

    /**
     * @param receiver
     */
    public EditProgram(InterpreterHandler receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        Form f = new Form();
        Display display = new Display();
        InputString inS = new InputString (f, Message.requestProgramId());
        f.parse();
        

        String name = inS.value();
        Program program = entity().getInterpreter().getProgram(name);
        
        if ( program == null){
            display.add(Message.noSuchProgram(name));
            display.display();
        }

        /* Program Manipulation Menu */
        else {
            Menu programManipulationMenu = new EvaluatorMenu(program);
            programManipulationMenu.open(); 
        }
    }
}
