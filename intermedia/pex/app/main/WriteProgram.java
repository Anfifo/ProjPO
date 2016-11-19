package pex.app.main;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

import pex.app.core.Interpreter;
import pex.app.core.InterpreterHandler;
import pex.app.core.Program
import pex.app.main.Message

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<InterpreterHandler> {
    /**
     * @param receiver
     */
    public WriteProgram(InterpreterHandler receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        File file = null;
        Display display = new Display();

        try{
            Form f = new Form();
            InputString prog_name = new InputString(f, Message.requestProgramId());
            f.parse();
            Interpreter interpreter = entity().getInterpreter();
            Program program = interpreter.getProgram(prog_name);
            
            if (program == null) {
                display.add(noSuchProgram());
                display.display();
            }

            else{
                Form f = new Form();
                InputString prog_file = new InputString(f, Message.programFileName());
                f.parse;

                String prog_txt = program.getAsText();

                PrintWriter writer = new PrintWriter("prog_file.txt");
                writer.println(prog_txt);
                writer.close();

            }
        }

        catch(InvalidOperation o){
            
        }
    }
}
