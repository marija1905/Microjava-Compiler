// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class ActParsWithParen implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ActParsSquare ActParsSquare;

    public ActParsWithParen (ActParsSquare ActParsSquare) {
        this.ActParsSquare=ActParsSquare;
        if(ActParsSquare!=null) ActParsSquare.setParent(this);
    }

    public ActParsSquare getActParsSquare() {
        return ActParsSquare;
    }

    public void setActParsSquare(ActParsSquare ActParsSquare) {
        this.ActParsSquare=ActParsSquare;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsSquare!=null) ActParsSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsSquare!=null) ActParsSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsSquare!=null) ActParsSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsWithParen(\n");

        if(ActParsSquare!=null)
            buffer.append(ActParsSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsWithParen]");
        return buffer.toString();
    }
}
