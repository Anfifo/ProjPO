package pex.app.evaluator;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import pex.core.Program;
import pex.core.BadArgumentException;

import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.literal.Literal;
import pex.core.expression.literal.StringLiteral;
import pex.core.expression.literal.IntegerLiteral;

/**
 * Run program.
 */
public class RunProgram extends ProgramCommand {

    /**
     * @param receiver
     */
    public RunProgram(Program receiver) {
        super(Label.RUN_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        try{
            entity().execute();
        }
        catch(BadArgumentException e){
            Display display = new Display();
            display.add("Erro na execução do programa: " + e.getMessage());
            display.display();
        }
    }
}
