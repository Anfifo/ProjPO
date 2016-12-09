package pex.app.evaluator;

//FIXME import used core classes

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.core.Program;
import pex.parser.NewParser;
import pex.core.expression.Expression;
import pex.parser.ParserException;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Replace expression in program.
 */
public class ReplaceExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public ReplaceExpression(Program receiver) {
        super(Label.REPLACE_EXPRESSION, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        Form f = new Form();
        InputInteger pos = new InputInteger (f, Message.requestPosition());
        InputString exp = new InputString (f, Message.requestExpression());
        f.parse();

        try{

            NewParser parser = new NewParser();

            int position = pos.value();


            if ( position >= entity().getExpressions().size() || position < 0 ) {
                throw new BadPositionException(position);
            }

            if(exp.value()==null){
                throw new BadExpressionException(exp.value());
            }
            Expression expression = parser.parseString(exp.value(), entity());
            entity().replace(position, expression);
        }
         catch(ParserException e){
             throw new BadExpressionException(exp.value());
         }
    }

}
