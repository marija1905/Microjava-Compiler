// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList1 implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private NumCharBoolConstList NumCharBoolConstList;

    public ConstDeclList1 (String I1, NumCharBoolConstList NumCharBoolConstList) {
        this.I1=I1;
        this.NumCharBoolConstList=NumCharBoolConstList;
        if(NumCharBoolConstList!=null) NumCharBoolConstList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public NumCharBoolConstList getNumCharBoolConstList() {
        return NumCharBoolConstList;
    }

    public void setNumCharBoolConstList(NumCharBoolConstList NumCharBoolConstList) {
        this.NumCharBoolConstList=NumCharBoolConstList;
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
        if(NumCharBoolConstList!=null) NumCharBoolConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NumCharBoolConstList!=null) NumCharBoolConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NumCharBoolConstList!=null) NumCharBoolConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(NumCharBoolConstList!=null)
            buffer.append(NumCharBoolConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList1]");
        return buffer.toString();
    }
}
