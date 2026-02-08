// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList1_node extends VarDeclList1 {

    private Square Square;
    private VarDeclList1 VarDeclList1;

    public VarDeclList1_node (Square Square, VarDeclList1 VarDeclList1) {
        this.Square=Square;
        if(Square!=null) Square.setParent(this);
        this.VarDeclList1=VarDeclList1;
        if(VarDeclList1!=null) VarDeclList1.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Square!=null) Square.accept(visitor);
        if(VarDeclList1!=null) VarDeclList1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Square!=null) Square.traverseTopDown(visitor);
        if(VarDeclList1!=null) VarDeclList1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Square!=null) Square.traverseBottomUp(visitor);
        if(VarDeclList1!=null) VarDeclList1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList1_node(\n");

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
        buffer.append(") [VarDeclList1_node]");
        return buffer.toString();
    }
}
