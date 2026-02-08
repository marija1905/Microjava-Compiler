// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class ConditionSquare_node extends ConditionSquare {

    private Condition Condition;
    private DesignatorStatementSquare DesignatorStatementSquare;

    public ConditionSquare_node (Condition Condition, DesignatorStatementSquare DesignatorStatementSquare) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.DesignatorStatementSquare=DesignatorStatementSquare;
        if(DesignatorStatementSquare!=null) DesignatorStatementSquare.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public DesignatorStatementSquare getDesignatorStatementSquare() {
        return DesignatorStatementSquare;
    }

    public void setDesignatorStatementSquare(DesignatorStatementSquare DesignatorStatementSquare) {
        this.DesignatorStatementSquare=DesignatorStatementSquare;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(DesignatorStatementSquare!=null) DesignatorStatementSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(DesignatorStatementSquare!=null) DesignatorStatementSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(DesignatorStatementSquare!=null) DesignatorStatementSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionSquare_node(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementSquare!=null)
            buffer.append(DesignatorStatementSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionSquare_node]");
        return buffer.toString();
    }
}
