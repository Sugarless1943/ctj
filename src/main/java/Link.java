public class Link {
    private String from;
    private String to;
    private String length;
    private String diameter;

    public Link(String from, String to, String length, String diameter) {
        this.from = from;
        this.to = to;
        this.length = length;
        this.diameter = diameter;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
}
