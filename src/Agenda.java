import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Evenement> events;

    public Agenda(){
        this.events = new ArrayList<>();
    }

    public void ajouterEvenement(Evenement e) {
        for (Evenement event : events) {
            if (event instanceof Reunion && e instanceof Reunion &&
                    event.getDate().equals(e.getDate())) {
                System.out.println("Conflit: réunion déjà programmée ce jour-là.");
                return;
            }
        }
        events.add(e);
    }
    public void supprimerAvantDate(Date date) {
        events.removeIf(event -> event.getDate().estAvant(date));
    }

    public void affichageDate(Date date) {
        for (Evenement event : events) {
            if (event.getDate().equals(date)) {
                System.out.println(event);
            }
        }
    }

    public List<Evenement> filterEvenements(String date, String type_event) {
       List<Evenement> filterEvenements = new ArrayList<>();

        String[] dateParts = date.split("/");
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Date format must be 'jour/mois/annee'.");
        }
        int jour = Integer.parseInt(dateParts[0]);
        int mois = Integer.parseInt(dateParts[1]);
        int annee = Integer.parseInt(dateParts[2]);

        Date targetDate = new Date(jour, mois, annee);

        for (Evenement event: events){
            boolean isSameDate = event.getDate().equals(targetDate);

            String eventType = event.getClass().getSimpleName().toLowerCase();
            boolean isSameType = eventType.equalsIgnoreCase(type_event.toLowerCase());

            if (isSameDate && isSameType){
                filterEvenements.add(event);
            }
        }
        return filterEvenements;
    }

    public void exporterEvenements(String fichier) {
        try (PrintWriter writer = new PrintWriter(fichier)) {
            for (Evenement event : events) {
                writer.println(event.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
