// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class FormParsList_node extends FormParsList {

    private FormParsTypeSquare FormParsTypeSquare;
    private FormParsList FormParsList;

    public FormParsList_node (FormParsTypeSquare FormParsTypeSquare, FormParsList FormParsList) {
        this.FormParsTypeSquare=FormParsTypeSquare;
        if(FormParsTypeSquare!=null) FormParsTypeSquare.setParent(this);
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
    }

    public FormParsTypeSquare getFormParsTypeSquare() {
        return FormParsTypeSquare;
    }

    public void setFormParsTypeSquare(FormParsTypeSquare FormParsTypeSquare) {
        this.FormParsTypeSquare=FormParsTypeSquare;
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsTypeSquare!=null) FormParsTypeSquare.accept(visitor);
        if(FormParsList!=null) FormParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsTypeSquare!=null) FormParsTypeSquare.traverseTopDown(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsTypeSquare!=null) FormParsTypeSquare.traverseBottomUp(visitor);
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList_node(\n");

        if(FormParsTypeSquare!=null)
            buffer.append(FormParsTypeSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList_node]");
        return buffer.toString();
    }
}
