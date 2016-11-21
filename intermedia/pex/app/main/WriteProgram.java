package pex.app.main;

/**
 *
 * Command WriteProgram <p>
 * Class responsible for writing(saving) a program(code) to a file if
 * program exists.<p>
 * Present files with same name as program will be replaced.
 * 
 * @author Grupo 31
 * @author Andre Fonseca 84698
 * @author Antonio Terra 84702
 * @version 1.0
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

import pex.core.Interpreter;
import pex.core.InterpreterHandler;
import pex.core.Program;
import pex.app.main.Message;

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

        Display display = new Display();

        try{
            Form f = new Form();
            InputString prog_name = new InputString(f, Message.requestProgramId());
            f.parse();
            Interpreter interpreter = entity().getInterpreter();
            Program program = interpreter.getProgram(prog_name.value());
            
            if (program == null) {
                display.add(Message.noSuchProgram(prog_name.value()));
                display.display();
            }

            else{
                Form form2 = new Form();
                InputString prog_file = new InputString(form2, Message.programFileName());
                form2.parse();

                String fileName = prog_file.value();
                String prog_txt = program.getAsText();
                
                PrintWriter writer = new PrintWriter(fileName);
                writer.println(prog_txt);
                writer.close();
            }
        }

        catch(FileNotFoundException o){
            Display disp = new Display();
            disp.add(Message.fileNotFound());
            disp.display();
        }
    }
}
