import java.util.List;
import java.util.Map;

public class Response {
    private List<Node> nodes;
    private List<Link> links;
    private List<Circuit> circuits;
    private Map<String, String[]> flows;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(List<Circuit> circuits) {
        this.circuits = circuits;
    }

    public Map<String, String[]> getFlows() {
        return flows;
    }

    public void setFlows(Map<String, String[]> flows) {
        this.flows = flows;
    }
}
