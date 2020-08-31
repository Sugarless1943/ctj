public class Bean {
    private String ID;
    private String Name;
    private String Parent_ID;
    private String Type;
    private String Length;
    private String Diameter;
    private String Cid;
    private String Parent_v_ID;
    private String Circuit;
    private String Standard_Uid;
    private String Parent_Tree;
    private String Heat_Coef;

    public Bean(String ID, String name, String parent_ID, String type, String length, String diameter, String cid, String parent_v_ID, String circuit, String standard_Uid, String parent_Tree, String heat_Coef) {
        this.ID = ID;
        this.Name = name;
        this.Parent_ID = parent_ID;
        this.Type = type;
        this.Length = length;
        this.Diameter = diameter;
        this.Cid = cid;
        this.Parent_v_ID = parent_v_ID;
        this.Circuit = circuit;
        this.Standard_Uid = standard_Uid;
        this.Parent_Tree = parent_Tree;
        this.Heat_Coef = heat_Coef;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getParent_ID() {
        return Parent_ID;
    }

    public void setParent_ID(String parent_ID) {
        this.Parent_ID = parent_ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        this.Length = length;
    }

    public String getDiameter() {
        return Diameter;
    }

    public void setDiameter(String diameter) {
        this.Diameter = diameter;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        this.Cid = cid;
    }

    public String getParent_v_ID() {
        return Parent_v_ID;
    }

    public void setParent_v_ID(String parent_v_ID) {
        this.Parent_v_ID = parent_v_ID;
    }

    public String getCircuit() {
        return Circuit;
    }

    public void setCircuit(String circuit) {
        this.Circuit = circuit;
    }

    public String getStandard_Uid() {
        return Standard_Uid;
    }

    public void setStandard_Uid(String standard_Uid) {
        this.Standard_Uid = standard_Uid;
    }

    public String getParent_Tree() {
        return Parent_Tree;
    }

    public void setParent_Tree(String parent_Tree) {
        this.Parent_Tree = parent_Tree;
    }

    public String getHeat_Coef() {
        return Heat_Coef;
    }

    public void setHeat_Coef(String heat_Coef) {
        this.Heat_Coef = heat_Coef;
    }
}
