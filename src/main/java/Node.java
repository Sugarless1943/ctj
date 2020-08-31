public class Node {
    private String nodeId;
    private String nodeName;
    private String nodeType;
    private String Cid;
    private String Parent_V_Id;
    private String Heat_Coef;

    public Node(String nodeId, String nodeName, String nodeType, String cid, String parent_V_Id, String Heat_Coef) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.Cid = cid;
        this.Parent_V_Id = parent_V_Id;
        this.Heat_Coef = Heat_Coef;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getParent_V_Id() {
        return Parent_V_Id;
    }

    public void setParent_V_Id(String parent_V_Id) {
        Parent_V_Id = parent_V_Id;
    }

    public String getHeat_Coef() {
        return Heat_Coef;
    }

    public void setHeat_Coef(String heat_Coef) {
        Heat_Coef = heat_Coef;
    }
}
