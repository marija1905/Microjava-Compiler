// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class ChooseFactor1_node2 extends ChooseFactor1 {

    private ActParsWithParen ActParsWithParen;

    public ChooseFactor1_node2 (ActParsWithParen ActParsWithParen) {
        this.ActParsWithParen=ActParsWithParen;
        if(ActParsWithParen!=null) ActParsWithParen.setParent(this);
    }

    public ActParsWithParen getActParsWithParen() {
        return ActParsWithParen;
    }

    public void setActParsWithParen(ActParsWithParen ActParsWithParen) {
        this.ActParsWithParen=ActParsWithParen;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsWithParen!=null) ActParsWithParen.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsWithParen!=null) ActParsWithParen.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsWithParen!=null) ActParsWithParen.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ChooseFactor1_node2(\n");

        if(ActParsWithParen!=null)
            buffer.append(ActParsWithParen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ChooseFactor1_node2]");
        return buffer.toString();
    }
}
