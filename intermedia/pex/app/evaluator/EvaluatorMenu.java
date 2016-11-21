package pex.app.evaluator;

/**
 * Program Manipulation. <p>
 * Menu class (UI) responsible executing the commands that edit and run programs. 
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 *
 */

import pex.core.Program;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

    /**
     * @param receiver the program which the menu will act upon.
     */
    public EvaluatorMenu(Program receiver) {
        super(Label.TITLE,
              new Command<?>[] { //
                  new ShowProgram(receiver), //
                      new RunProgram(receiver), //
                      new AddExpression(receiver), //
                      new ReplaceExpression(receiver), //
                      new ShowAllIdentifiers(receiver), //
                      new ShowUninitializedIdentifiers(receiver), //
                      });
    }

}
