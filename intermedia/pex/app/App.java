package pex.app;

// import core entities;
import pex.core.InterpreterHandler;
import pex.core.Interpreter;
import pex.core.Program;

import pex.AppIO;
import pex.parser.*;
import pex.app.main.MainMenu;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO {
    // Add fileds here if needed

    public App() {
	// add core here if needed
    }

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        Display display = new Display();

        display.add(str);
        display.display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        Form f = new Form();
        InputString str = new InputString(f, null);
        f.parse();
        return str.value();
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
        Form f = new Form();
        InputInteger n  = new InputInteger(f, null);
        f.parse();
        return n.value();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //FIXME create main core object
        
        AppIO app = new App();
        InterpreterHandler receiver = new InterpreterHandler(app);
        receiver.newInterpreter();

        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {

                NewParser parser = new NewParser();
                Program prog = parser.parseFile(datafile, "import", receiver);

                receiver.getInterpreter().addProgram(prog);
                
            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }
        
        MainMenu menu = new MainMenu(receiver);
        menu.open();
    }
}
