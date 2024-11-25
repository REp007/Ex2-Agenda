abstract public class Evenement {
    protected Date date;

    public Evenement(Date date) {
        this.date = date;
    }

    public Date getDate() { return date; }
    public void setDate(Date newDate) { this.date = newDate; }

    @Override
    public String toString() {
        return "Event on " + date.toString();
    }
}
