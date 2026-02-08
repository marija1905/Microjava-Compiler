// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class NoFactor_minus extends Factor {

    private Factor1 Factor1;

    public NoFactor_minus (Factor1 Factor1) {
        this.Factor1=Factor1;
        if(Factor1!=null) Factor1.setParent(this);
    }

    public Factor1 getFactor1() {
        return Factor1;
    }

    public void setFactor1(Factor1 Factor1) {
        this.Factor1=Factor1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Factor1!=null) Factor1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor1!=null) Factor1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor1!=null) Factor1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoFactor_minus(\n");

        if(Factor1!=null)
            buffer.append(Factor1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoFactor_minus]");
        return buffer.toString();
    }
}
