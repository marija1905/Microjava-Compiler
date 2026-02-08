// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class Statement_return extends Statement {

    private ExprSquare ExprSquare;

    public Statement_return (ExprSquare ExprSquare) {
        this.ExprSquare=ExprSquare;
        if(ExprSquare!=null) ExprSquare.setParent(this);
    }

    public ExprSquare getExprSquare() {
        return ExprSquare;
    }

    public void setExprSquare(ExprSquare ExprSquare) {
        this.ExprSquare=ExprSquare;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprSquare!=null) ExprSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprSquare!=null) ExprSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprSquare!=null) ExprSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_return(\n");

        if(ExprSquare!=null)
            buffer.append(ExprSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_return]");
        return buffer.toString();
    }
}
