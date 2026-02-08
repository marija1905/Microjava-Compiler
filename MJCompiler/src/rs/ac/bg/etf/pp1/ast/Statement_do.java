// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class Statement_do extends Statement {

    private StatementDO StatementDO;
    private Statement Statement;
    private StatementWhile StatementWhile;
    private ConditionSquare ConditionSquare;

    public Statement_do (StatementDO StatementDO, Statement Statement, StatementWhile StatementWhile, ConditionSquare ConditionSquare) {
        this.StatementDO=StatementDO;
        if(StatementDO!=null) StatementDO.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.StatementWhile=StatementWhile;
        if(StatementWhile!=null) StatementWhile.setParent(this);
        this.ConditionSquare=ConditionSquare;
        if(ConditionSquare!=null) ConditionSquare.setParent(this);
    }

    public StatementDO getStatementDO() {
        return StatementDO;
    }

    public void setStatementDO(StatementDO StatementDO) {
        this.StatementDO=StatementDO;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public StatementWhile getStatementWhile() {
        return StatementWhile;
    }

    public void setStatementWhile(StatementWhile StatementWhile) {
        this.StatementWhile=StatementWhile;
    }

    public ConditionSquare getConditionSquare() {
        return ConditionSquare;
    }

    public void setConditionSquare(ConditionSquare ConditionSquare) {
        this.ConditionSquare=ConditionSquare;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementDO!=null) StatementDO.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(StatementWhile!=null) StatementWhile.accept(visitor);
        if(ConditionSquare!=null) ConditionSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementDO!=null) StatementDO.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(StatementWhile!=null) StatementWhile.traverseTopDown(visitor);
        if(ConditionSquare!=null) ConditionSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementDO!=null) StatementDO.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(StatementWhile!=null) StatementWhile.traverseBottomUp(visitor);
        if(ConditionSquare!=null) ConditionSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_do(\n");

        if(StatementDO!=null)
            buffer.append(StatementDO.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementWhile!=null)
            buffer.append(StatementWhile.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionSquare!=null)
            buffer.append(ConditionSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_do]");
        return buffer.toString();
    }
}
