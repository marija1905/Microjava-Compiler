// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class Factor1_new extends Factor1 {

    private Type Type;
    private ChooseFactor1 ChooseFactor1;

    public Factor1_new (Type Type, ChooseFactor1 ChooseFactor1) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ChooseFactor1=ChooseFactor1;
        if(ChooseFactor1!=null) ChooseFactor1.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ChooseFactor1 getChooseFactor1() {
        return ChooseFactor1;
    }

    public void setChooseFactor1(ChooseFactor1 ChooseFactor1) {
        this.ChooseFactor1=ChooseFactor1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ChooseFactor1!=null) ChooseFactor1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ChooseFactor1!=null) ChooseFactor1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ChooseFactor1!=null) ChooseFactor1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor1_new(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ChooseFactor1!=null)
            buffer.append(ChooseFactor1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor1_new]");
        return buffer.toString();
    }
}
