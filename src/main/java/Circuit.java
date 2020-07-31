public class Circuit {
    private String name;
    private String[] circuit;

    public Circuit(String name, String[] circuit) {
        this.name = name;
        this.circuit = circuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCircuit() {
        return circuit;
    }

    public void setCircuit(String[] circuit) {
        this.circuit = circuit;
    }
}
