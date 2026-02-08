// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:55:33


package rs.ac.bg.etf.pp1.ast;

public class NoDesignatorStatementSquare extends DesignatorStatementSquare {

    public NoDesignatorStatementSquare () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoDesignatorStatementSquare(\n");

        buffer.append(tab);
        buffer.append(") [NoDesignatorStatementSquare]");
        return buffer.toString();
    }
}
