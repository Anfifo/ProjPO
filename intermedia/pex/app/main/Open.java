package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import pex.core.InterpreterHandler;
import pex.core.Interpreter;

import pex.app.main.Message;
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
    public final void execute() throws InvalidOperation{
        Interpreter interpreter = null;
        int i = 0;

        try{
            Form f = new Form();
            InputString nameFile = new InputString(f, Message.openFile());
            f.parse();    

            String name = nameFile.value();
            File file = null;

            file = new File(name);

            if (file.exists()) {

                FileInputStream fileStream = new FileInputStream(name+".ser");
                ObjectInputStream in = new ObjectInputStream(fileStream);
                interpreter = (Interpreter) in.readObject();

                in.close();
                fileStream.close();
            }

            else{
                Display display = new Display();

                display.add(Message.fileNotFound());
                display.display();
            }
        }
        catch(FileNotFoundException fnf){
            Display disp = new Display();
            disp.add(Message.fileNotFound());
            disp.display();
        }
        catch(ClassNotFoundException cnf){
            throw new InvalidOperation();
        }
        catch(IOException io){
            throw new InvalidOperation();
        }
    }
}
