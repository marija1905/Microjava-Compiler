// generated with ast extension for cup
// version 0.8
// 28/8/2025 13:48:41


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList_md_node extends VarDeclList_md {

    private VarDeclList VarDeclList;
    private VarDeclList_md VarDeclList_md;

    public VarDeclList_md_node (VarDeclList VarDeclList, VarDeclList_md VarDeclList_md) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarDeclList_md=VarDeclList_md;
        if(VarDeclList_md!=null) VarDeclList_md.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public VarDeclList_md getVarDeclList_md() {
        return VarDeclList_md;
    }

    public void setVarDeclList_md(VarDeclList_md VarDeclList_md) {
        this.VarDeclList_md=VarDeclList_md;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarDeclList_md!=null) VarDeclList_md.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarDeclList_md!=null) VarDeclList_md.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarDeclList_md!=null) VarDeclList_md.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList_md_node(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList_md!=null)
            buffer.append(VarDeclList_md.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList_md_node]");
        return buffer.toString();
    }
}
