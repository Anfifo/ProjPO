package pex.app.evaluator;


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
 * Add expression.
 */
public class AddExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public AddExpression(Program receiver) {
        super(Label.ADD_EXPRESSION, receiver);
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

            Expression expression = parser.parseString(exp.value(), entity());

            entity().add(position, expression);
        }

         catch(BadPositionException p){  }
         catch(ParserException e){ throw new BadExpressionException(exp.value()); }
    }
}
