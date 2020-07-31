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

    public Bean(String ID, String name, String parent_ID, String type, String length, String diameter, String cid, String parent_v_ID, String circuit) {
        this.ID = ID;
        Name = name;
        Parent_ID = parent_ID;
        Type = type;
        Length = length;
        Diameter = diameter;
        Cid = cid;
        Parent_v_ID = parent_v_ID;
        Circuit = circuit;
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
        Name = name;
    }

    public String getParent_ID() {
        return Parent_ID;
    }

    public void setParent_ID(String parent_ID) {
        Parent_ID = parent_ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        Length = length;
    }

    public String getDiameter() {
        return Diameter;
    }

    public void setDiameter(String diameter) {
        Diameter = diameter;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getParent_v_ID() {
        return Parent_v_ID;
    }

    public void setParent_v_ID(String parent_v_ID) {
        Parent_v_ID = parent_v_ID;
    }

    public String getCircuit() {
        return Circuit;
    }

    public void setCircuit(String circuit) {
        Circuit = circuit;
    }
}
