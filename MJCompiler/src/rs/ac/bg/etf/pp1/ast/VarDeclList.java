// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private Square Square;
    private VarDeclList1 VarDeclList1;

    public VarDeclList (Type Type, Square Square, VarDeclList1 VarDeclList1) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Square=Square;
        if(Square!=null) Square.setParent(this);
        this.VarDeclList1=VarDeclList1;
        if(VarDeclList1!=null) VarDeclList1.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Square getSquare() {
        return Square;
    }

    public void setSquare(Square Square) {
        this.Square=Square;
    }

    public VarDeclList1 getVarDeclList1() {
        return VarDeclList1;
    }

    public void setVarDeclList1(VarDeclList1 VarDeclList1) {
        this.VarDeclList1=VarDeclList1;
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
        if(Square!=null) Square.accept(visitor);
        if(VarDeclList1!=null) VarDeclList1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Square!=null) Square.traverseTopDown(visitor);
        if(VarDeclList1!=null) VarDeclList1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Square!=null) Square.traverseBottomUp(visitor);
        if(VarDeclList1!=null) VarDeclList1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Square!=null)
            buffer.append(Square.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList1!=null)
            buffer.append(VarDeclList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
