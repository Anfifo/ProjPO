package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.File;

//FIXME import used core classes
import pex.core.InterpreterHandler;

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
    public final void execute() throws InvalidOperation, IOException, ClassNotFoundException {
        Interpreter inter = null;
        int i = 0;
        
        try{
            Form f = new Form();
            InputString name = new InputString(f, Message.openFile());
            f.parse();    

            File file = null;

            file = new File("name.txt");

            if (file.exists()) {

                FileInputStream file = new FileInputStream("name.ser");
                ObjectInputStream in = new ObjectInputStream(file);
                inter = (Interpreter) in.readObject();
                in.close();
                file.close();
            }

            else{
                Display display = new Display();

                while( !file.exists() ){

                display.add(Message.fileNotFound());
                display.display();

                InputString new_name = new InputString(f, Message.openFile());
                file = new File("new_name.txt");

                }

                FileInputStream file = new FileInputStream("new_name.ser");
                ObjectInputStream in = new ObjectInputStream(file);
                inter = (Interpreter) in.readObject();
                in.close();
                file.close();
            }
        }

        catch(InvalidOperation o){
            
        }
        catch(IOException i){
            
        }
        catch(ClassNotFoundException c){
            
        }
            

    }
}
