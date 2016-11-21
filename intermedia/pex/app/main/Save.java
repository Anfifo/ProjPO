package pex.app.main;

import java.io.IOException;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import pex.core.Interpreter;
import pex.core.InterpreterHandler;
import pex.core.Program;

//FIXME import used core classes
import pex.app.main.Message;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<InterpreterHandler> {
    /**
     * @param receiver
     */
    public Save(InterpreterHandler receiver) {
        super(Label.SAVE, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        try{

            Form f = new Form();
            InputString nameFile = new InputString(f, Message.saveAs());
            f.parse();
            
            File file = null;
            
            String name = nameFile.value();
            
            file = new File(name);
            
            if ( !file.exists() ) {
                file.createNewFile();
            }

            FileOutputStream fileStream = new FileOutputStream(name+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            
            out.writeObject(entity().getInterpreter() );
            out.close();

        }
        catch(IOException io){
            throw new InvalidOperation();
        }
    }
}
