// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class MethodSignature implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodSignatureType MethodSignatureType;
    private FormParsSquare FormParsSquare;

    public MethodSignature (MethodSignatureType MethodSignatureType, FormParsSquare FormParsSquare) {
        this.MethodSignatureType=MethodSignatureType;
        if(MethodSignatureType!=null) MethodSignatureType.setParent(this);
        this.FormParsSquare=FormParsSquare;
        if(FormParsSquare!=null) FormParsSquare.setParent(this);
    }

    public MethodSignatureType getMethodSignatureType() {
        return MethodSignatureType;
    }

    public void setMethodSignatureType(MethodSignatureType MethodSignatureType) {
        this.MethodSignatureType=MethodSignatureType;
    }

    public FormParsSquare getFormParsSquare() {
        return FormParsSquare;
    }

    public void setFormParsSquare(FormParsSquare FormParsSquare) {
        this.FormParsSquare=FormParsSquare;
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
        if(MethodSignatureType!=null) MethodSignatureType.accept(visitor);
        if(FormParsSquare!=null) FormParsSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignatureType!=null) MethodSignatureType.traverseTopDown(visitor);
        if(FormParsSquare!=null) FormParsSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignatureType!=null) MethodSignatureType.traverseBottomUp(visitor);
        if(FormParsSquare!=null) FormParsSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodSignature(\n");

        if(MethodSignatureType!=null)
            buffer.append(MethodSignatureType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsSquare!=null)
            buffer.append(FormParsSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodSignature]");
        return buffer.toString();
    }
}
