public class Circuits {
    private String name;
    private String[] circuit;

    public Circuits(String name, String[] circuit) {
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
