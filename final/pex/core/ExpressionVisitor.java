package pex.core;

import pex.core.expression.Expression;
import pex.core.expression.Identifier;
import pex.core.expression.compositeexpression.unaryexpression.*;
import pex.core.expression.compositeexpression.binaryexpression.*;
import pex.core.expression.compositeexpression.ternaryexpression.*;
import pex.core.expression.compositeexpression.variadicexpression.*;
import pex.core.expression.compositeexpression.*;
import pex.core.expression.literal.*;


public interface ExpressionVisitor{
	
	public void visit(Add expression);
	public void visit(And expression);
	public void visit(Div expression);
	public void visit(Eq expression);
	public void visit(Ge expression);
	public void visit(Gt expression);
	public void visit(Le expression);
	public void visit(Lt expression);
	public void visit(Mod expression);
	public void visit(Mul expression);
	public void visit(Ne expression);
	public void visit(Or expression);
	public void visit(Set expression);
	public void visit(Sub expression);
	public void visit(While expression);
	public void visit(If expression);
	public void visit(Call expression);
	public void visit(Neg expression);
	public void visit(Not expression);
	public void visit(Print expression);
	public void visit(Seq expression);
	public void visit(ReadI expression);
	public void visit(ReadS expression);
	public void visit(Identifier expression);
	public void visit(IntegerLiteral expression);
	public void visit(StringLiteral expression);
}