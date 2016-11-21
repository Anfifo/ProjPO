package pex.app.main;

import pex.core.InterpreterHandler;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

/**
 * Menu builder.
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
*/
public class MainMenu extends Menu {

    /**
     * Creates menu with avaible commands
     * @param receiver the Class to which the menu acts on
     */
    public MainMenu(InterpreterHandler receiver) {
        super(Label.TITLE,
              new Command<?>[] { //
                  new New(receiver), //
                  new Open(receiver), //
                  new Save(receiver), //
                  new NewProgram(receiver), //
                  new ReadProgram(receiver), //
                  new WriteProgram(receiver), //
                  new EditProgram(receiver), //
                });
    }
}
