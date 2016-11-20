package pex.app.main;

import pex.app.main.Message;
import pex.parser.NewParser;
import java.io.File;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

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
    public final void execute() {
        File file = null;
        Form f = new Form();
        InputString nameFile = new InputString(f, Message.programFileName());
        f.parse(); 
        file = new File(nameFile.value());

        if (!file.exists()) {
            Display display = new Display;

            display.add(fileNotFound());
            display.display();
        }
        
        else{
            String progName = nameFile.value().substring(0, (nameFile.value().Length - 4));

            Program prog = NewParser.parseFile(nameFile.value(), progName, entity());

            entity().getInterpreter().addProgram(prog);
        }
    }
}
