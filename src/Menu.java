import java.util.Scanner;

public class Menu {
    static Scanner scanner;

    private static int menu() {
        System.out.println("=== Menu Gestion des Cours ===");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Ajouter un instructeur");
        System.out.println("3. Ajouter un cours");
        System.out.println("4. Inscrire un étudiant à un cours");
        System.out.println("5. Assigner un instructeur à un cours");
        System.out.println("6. Afficher les détails d’un cours");
        System.out.println("7. Generer votre Certificat");
        System.out.println("8. Quitter");
        System.out.print("Entrez votre choix : ");
        // if (choix < 1 || choix > 7) {choix = scanner.nextInt();}
        int choix = scanner.nextInt();
        return choix;
    }

    public static void start() {
        scanner = new Scanner(System.in);
        int choix;
        do {
            choix = menu();
            operationsSwitcher(choix);
        } while (choix != 8);
    }

    private static void operationsSwitcher(int numberOperation) {
        switch (numberOperation) {
            case 1:
                System.out.println("Enter votre ID : ");
                int EtudiantId = scanner.nextInt();
                System.out.println("Enter votre Nom : ");
                String nom = scanner.next();
                System.out.println("Enter votre Email : ");
                String email = scanner.next();
                new Cours().ajouterEtudiant(new Etudiant(EtudiantId, nom, email));
                break;
            case 2:
                // Ajouter un instructeur
                System.out.println("Enter votre ID : ");
                int instructorId = scanner.nextInt();
                System.out.println("Enter votre specialisaté : ");
                String specialisation = scanner.next();
                System.out.println("Enter votre Nom : ");
                String instructorNom = scanner.next();
                new Cours().ajouterInstructeur(new Instructeur(instructorId, specialisation, instructorNom));
                break;
            case 3:
                // Ajouter un cours:
                System.out.println("Enter ID de cours : ");
                int coursId = scanner.nextInt();
                System.out.println("Enter Title de cours : ");
                String title = scanner.next();
                System.out.println("Enter Description de cours : ");
                String description = scanner.next();
                new Etudiant().ajouterCourse(new Cours(coursId, title, description));
                break;
            case 4:
                // Inscrire un étudiant à un cours.
                System.out.println("Entrez l’ID du cours :");
                int coursID = scanner.nextInt();
                System.out.println("Entrez l’ID de l’étudiant :");
                int studentID = scanner.nextInt();
                new Etudiant().inscrire(coursID, studentID);
                break;
            case 5:
                // Assigner un instructeur à un cours
                System.out.println("Entrez l’ID de l'instructeur :");
                int instructorID = scanner.nextInt();
                Instructeur instructeur = new Cours().getInstructeur(instructorID);
                if (instructeur == null) {
                    System.out.println("Something went wrong, this instructor not found !!");
                    break;
                } else {
                    System.out.println("Entrez l’ID de cours :");
                    int coursIDForInstructor = scanner.nextInt();
                    instructeur.cours = Utilities.getCoursById(coursIDForInstructor);
                    new Cours().assignerInstructeur(instructeur);
                }

                break;
            case 6:
                // Afficher les détails d’un cours
                new Cours().afficherDetails();
                break;
            case 7:
                // Generer certificat
                System.out.println("Entrez votre l’ID :");
                int studentIDe = scanner.nextInt();
                System.out.println("Entrez l’ID du cours :");
                int coursIDe = scanner.nextInt();
                Etudiant etudiant = Utilities.getStudentById(studentIDe);
                Cours cours = Utilities.getCoursById(coursIDe);
                if (etudiant == null || cours == null) {
                    System.out.println("Something went wrong!!! Try again:");
                }
                new Certification(studentIDe, cours, etudiant).genererCertification();
                break;
        }
    }

}
