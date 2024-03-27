import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class CalculatorSuperiorVisitor extends CalculatorBaseVisitor<Object>{

    Map<String, Object> memory;

    public CalculatorSuperiorVisitor(){
        this.memory = new HashMap<String, Object>();
    }

    @Override
    public Object visitProg(CalculatorParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public Object visitAssing(CalculatorParser.AssingContext ctx) {

        if(ctx.lvalue() instanceof CalculatorParser.IdContext){
            String id = ctx.lvalue().getText();
            Object value = visit(ctx.exp());
            memory.put(id, value);

            System.out.println("memory: " + memory);
        }

        return super.visitAssing(ctx);
    }

    @Override
    public Object visitBrances(CalculatorParser.BrancesContext ctx) {
        return super.visitBrances(ctx);
    }

    @Override
    public Object visitPrint(CalculatorParser.PrintContext ctx) {
        Object value = visit(ctx.exp());
        System.out.println(value);
        return 0;
    }

    @Override
    public Object visitBasicsExprs(CalculatorParser.BasicsExprsContext ctx) {
        return super.visitBasicsExprs(ctx);
    }

    @Override
    public Object visitPlusMinus(CalculatorParser.PlusMinusContext ctx) {

        Number left = (Number) visit(ctx.aexp());
        Number right = (Number) visit(ctx.mexp());

        if(ctx.op.getType() == CalculatorParser.PLUS){

            return left.longValue() + right.longValue();
        }

        return left.byteValue() - right.byteValue();
    }

    @Override
    public Object visitMoreExprs(CalculatorParser.MoreExprsContext ctx) {
        return super.visitMoreExprs(ctx);
    }

    @Override
    public Object visitMultDivMod(CalculatorParser.MultDivModContext ctx) {
        Number left = (Number) visit(ctx.mexp());
        Number right = (Number) visit(ctx.sexp());

        if(ctx.op.getType() == CalculatorParser.MULT){
            return left.byteValue() * right.byteValue();
        }
        if(ctx.op.getType() == CalculatorParser.DIV){
            return left.byteValue() / right.byteValue();
        }

        return left.byteValue() % right.byteValue();
    }

    @Override
    public Object visitLiteralExprs(CalculatorParser.LiteralExprsContext ctx) {
        return super.visitLiteralExprs(ctx);
    }

    @Override
    public Object visitInt(CalculatorParser.IntContext ctx) {
       return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Object visitAcessorValue(CalculatorParser.AcessorValueContext ctx) {
        return super.visitAcessorValue(ctx);
    }

    @Override
    public Object visitValue(CalculatorParser.ValueContext ctx) {

        return super.visitValue(ctx);
    }

    @Override
    public Object visitId(CalculatorParser.IdContext ctx) {
        return memory.get(ctx.ID().getText());
    }
}