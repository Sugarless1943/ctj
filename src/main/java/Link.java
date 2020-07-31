public class Link {
    private String form;
    private String to;
    private String length;
    private String diameter;

    public Link(String form, String to, String length, String diameter) {
        this.form = form;
        this.to = to;
        this.length = length;
        this.diameter = diameter;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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
