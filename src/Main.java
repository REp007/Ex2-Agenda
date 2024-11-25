import java.util.List;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.ajouterEvenement(new Anniversaire(new Date(14, 10, 2023), "anv1"));
        agenda.ajouterEvenement(new Anniversaire(new Date(19, 12, 2023), "anv2"));

        // Meets
        agenda.ajouterEvenement(new Reunion(new Date(10, 12, 2023),10, 11, "meet 1"));
        agenda.ajouterEvenement(new Reunion(new Date(19, 12, 2023), 10, 11,  "meet 2"));
        agenda.ajouterEvenement(new Reunion(new Date(1, 1, 2024), 10, 11, "meet 3"));

        // Conflict Meet
        agenda.ajouterEvenement(new Reunion(new Date(1, 1, 2024), 10, 11, "meet 3(1)"));

        // Remove Events Before 1/11/2023
        agenda.supprimerAvantDate(new Date(1, 11, 2023));

        // Display Events on 19/12/2023
        agenda.affichageDate(new Date(19, 12, 2023));

        // Display Meetings on 1/1/2024
        System.out.println("Réunions du 01/01/2024 :");
        List<Evenement> filteredReunions = agenda.filterEvenements("01/01/2024", "reunion");
        for (Evenement event : filteredReunions) {
            System.out.println(event);
        }

        agenda.exporterEvenements("agenda.txt");
    }
}