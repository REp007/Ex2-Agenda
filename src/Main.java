public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.ajouterEvenement(new Anniversaire(new Date(14, 10, 2023), "John"));
        agenda.ajouterEvenement(new Anniversaire(new Date(19, 12, 2023), "Doe"));

        // Meets
        agenda.ajouterEvenement(new Reunion(new Date(10, 12, 2023),10, 11, "Team Meeting"));
        agenda.ajouterEvenement(new Reunion(new Date(19, 12, 2023), 10, 11,  "Project Review"));
        agenda.ajouterEvenement(new Reunion(new Date(1, 1, 2024), 10, 11, "Kickoff Meeting"));

        // Conflict Meet
        agenda.ajouterEvenement(new Reunion(new Date(1, 1, 2024), 10, 11, "Another Meeting"));

        // Remove Events Before 1/11/2023
        agenda.supprimerAvantDate(new Date(1, 11, 2023));

        // Display Events on 19/12/2023
        agenda.affichageDate(new Date(19, 12, 2023));

        // Display Meetings on 1/1/2024
        System.out.println("Réunions du 01/01/2024 :");
        agenda.filterEvenements("reunion");

        // Export Events
//        agenda.exporterEvenements("agenda.txt");
    }
}