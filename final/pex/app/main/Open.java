package pex.app.main;

/**
 *
 * Command Open <p>
 * Class responsible for opening(loading) an interpreter 
 * saved in given input file if it exists.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

import pex.core.Interpreter;
import pex.core.InterpreterHandler;

import pex.app.main.Message;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
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
    public final void execute() throws InvalidOperation{
        Interpreter interpreter = null;
        int i = 0;
        String name = "";
        
        try{

            Form f = new Form();
            InputString nameFile = new InputString(f, Message.openFile());
            f.parse();    

            name = nameFile.value();

            entity().openInterpreter(name);

        }
        catch(NullPointerException np){
            Display display = new Display();

            display.add(Message.fileNotFound(name));
            display.display();
        }
        catch(FileNotFoundException f){
            Display display = new Display();

            display.add(Message.fileNotFound(name));
            display.display();
        }
    }
}
