// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class Statement_print extends Statement {

    private Expr Expr;
    private NumConstSquare NumConstSquare;

    public Statement_print (Expr Expr, NumConstSquare NumConstSquare) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.NumConstSquare=NumConstSquare;
        if(NumConstSquare!=null) NumConstSquare.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public NumConstSquare getNumConstSquare() {
        return NumConstSquare;
    }

    public void setNumConstSquare(NumConstSquare NumConstSquare) {
        this.NumConstSquare=NumConstSquare;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(NumConstSquare!=null) NumConstSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(NumConstSquare!=null) NumConstSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(NumConstSquare!=null) NumConstSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_print(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NumConstSquare!=null)
            buffer.append(NumConstSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_print]");
        return buffer.toString();
    }
}
