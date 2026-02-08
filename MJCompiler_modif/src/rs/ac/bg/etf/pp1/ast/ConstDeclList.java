// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstDeclList1 ConstDeclList1;
    private ConstDeclList2 ConstDeclList2;

    public ConstDeclList (Type Type, ConstDeclList1 ConstDeclList1, ConstDeclList2 ConstDeclList2) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDeclList1=ConstDeclList1;
        if(ConstDeclList1!=null) ConstDeclList1.setParent(this);
        this.ConstDeclList2=ConstDeclList2;
        if(ConstDeclList2!=null) ConstDeclList2.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstDeclList1 getConstDeclList1() {
        return ConstDeclList1;
    }

    public void setConstDeclList1(ConstDeclList1 ConstDeclList1) {
        this.ConstDeclList1=ConstDeclList1;
    }

    public ConstDeclList2 getConstDeclList2() {
        return ConstDeclList2;
    }

    public void setConstDeclList2(ConstDeclList2 ConstDeclList2) {
        this.ConstDeclList2=ConstDeclList2;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclList1!=null) ConstDeclList1.accept(visitor);
        if(ConstDeclList2!=null) ConstDeclList2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclList1!=null) ConstDeclList1.traverseTopDown(visitor);
        if(ConstDeclList2!=null) ConstDeclList2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclList1!=null) ConstDeclList1.traverseBottomUp(visitor);
        if(ConstDeclList2!=null) ConstDeclList2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList1!=null)
            buffer.append(ConstDeclList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList2!=null)
            buffer.append(ConstDeclList2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
