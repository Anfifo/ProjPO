package pex.app.main;

import pex.core.InterpreterHandler;
import pex.core.Interpreter;
import pex.core.Program;

import pex.app.main.Message;
import pex.parser.*;
import java.io.File;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;


/**
 * Read existing program.
 */
public class ReadProgram extends Command<InterpreterHandler> {
    /**
     * @param receiver
     */
    public ReadProgram(InterpreterHandler receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation{
        Form f = new Form();
        InputString nameFile = new InputString(f, Message.programFileName());
        f.parse(); 
        
        File file = new File(nameFile.value());

        if (!file.exists()) {
            Display display = new Display();

            display.add(Message.fileNotFound());
            display.display();
        }

        
        else{
            NewParser parser = new NewParser();
            try{
                Program prog = parser.parseFile(nameFile.value(), nameFile.value(), entity());
                entity().getInterpreter().addProgram(prog);
                entity().applyChange();
            }
            catch(ParserException o){ o.printStackTrace(); }
        }
    }
}
