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
	
	public Literal visit(Add expression);
	public Literal visit(And expression);
	public Literal visit(Div expression);
	public Literal visit(Eq expression);
	public Literal visit(Ge expression);
	public Literal visit(Gt expression);
	public Literal visit(Le expression);
	public Literal visit(Lt expression);
	public Literal visit(Mod expression);
	public Literal visit(Mul expression);
	public Literal visit(Ne expression);
	public Literal visit(Or expression);
	public Literal visit(Set expression);
	public Literal visit(Sub expression);
	public Literal visit(While expression);
	public Literal visit(If expression);
	public Literal visit(Call expression);
	public Literal visit(Neg expression);
	public Literal visit(Not expression);
	public Literal visit(Print expression);
	public Literal visit(Seq expression);
	public Literal visit(ReadI expression);
	public Literal visit(ReadS expression);
	public Literal visit(Identifier expression);
	public Literal visit(IntegerLiteral expression);
	public Literal visit(StringLiteral expression);
}