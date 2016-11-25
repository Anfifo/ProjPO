package pex.app.main;

/**
 *
 * Command Save(Interpreter) <p>
 * Class responsible for saving current interpreter to
 * it's related file if it exists.<p> In case no file
 * is associated with current interpreter a new 
 * fileName will be asked and created.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */


// File saving imports
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


import pex.core.Program;
import pex.core.Interpreter;
import pex.core.InterpreterHandler;


import pex.app.main.Message;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Command;
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

            if(!entity().getChangedStatus())
                return;
            
            if (entity().getFileName() == null){
                Form f = new Form();
                InputString nameFile = new InputString(f, Message.newSaveAs());
                f.parse();
                
                String name = nameFile.value();
            
                entity().setFileName(name);    
            }

            
            FileOutputStream fileStream = new FileOutputStream(entity().getFileName());
            ObjectOutputStream out = new ObjectOutputStream(fileStream);
            out.writeObject(entity().getInterpreter() );
            out.close();
            fileStream.close();
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }
}
