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

    public void filterEvenements(String type) {
        for (Evenement event : events) {
            if (event instanceof Anniversaire && type.equals("anniversaire") ||
                    event instanceof Reunion && type.equals("reunion")) {
                System.out.println(event);
            }
        }
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
