public class Reunion extends Evenement {
    private int heureDebut;
    private int heureFin;
    private String description;

    public Reunion(Date date,int heureDebut, int heureFin, String description) {
        super(date);
        this.heureDebut = heureDebut;
        this.description = description;
        this.heureFin = heureFin;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
