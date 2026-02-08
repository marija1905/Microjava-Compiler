// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class Choose_ds_p extends DesignatorStatement {

    private Designator Designator;
    private ActParsSquare ActParsSquare;

    public Choose_ds_p (Designator Designator, ActParsSquare ActParsSquare) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsSquare=ActParsSquare;
        if(ActParsSquare!=null) ActParsSquare.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsSquare getActParsSquare() {
        return ActParsSquare;
    }

    public void setActParsSquare(ActParsSquare ActParsSquare) {
        this.ActParsSquare=ActParsSquare;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsSquare!=null) ActParsSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsSquare!=null) ActParsSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsSquare!=null) ActParsSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Choose_ds_p(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsSquare!=null)
            buffer.append(ActParsSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Choose_ds_p]");
        return buffer.toString();
    }
}
