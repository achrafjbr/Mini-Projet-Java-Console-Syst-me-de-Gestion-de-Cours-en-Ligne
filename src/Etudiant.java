import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Etudiant {

    int studentId;
    String nom;
    String email;
    static List<Cours> courses = new ArrayList<>();

    public Etudiant() {
    }

    public Etudiant(int studentId, String nom, String email) {
        this.studentId = studentId;
        this.nom = nom;
        this.email = email;
    }

    public void ajouterCourse(Cours cours) {
        courses.add(cours);
        System.out.println("The cours : " + cours.titre + " successful added ");
    }

    public void inscrire(int coursId, int studentId) {
        Etudiant etudiant = Utilities.getStudentById(studentId);
        if (etudiant == null) {
            System.out.println("This ID not found");
        } else {
            if (new Paiment().aPaye(etudiant)) {
                System.out.println("T'a déja acheté ce cours");
            } else {
                System.out.println("Il faut acheter le cours, aprés tu peut le prendre");

                System.out.println("Est ce que vous voulez acheter le Course : Taper (1) si non Taper (0) ");
                Scanner scanner = new Scanner(System.in);
                int response = scanner.nextInt();
                if (response == 1) {
                    Cours cours = Utilities.getCoursById(coursId);
                    if (cours == null) {
                        System.out.println("This ID not found");
                    }
                    new Paiment().effectuerPaiement(new Paiment(1000, "debit-card", cours, etudiant));
                }

            }
        }

    }

    public void afficherCours() {
        for (Cours cours : courses) {
            System.out.println(" ID : " + cours.courseId + " ");
            System.out.println(" Titre : " + cours.titre + " ");
            System.out.println(" Description : " + cours.description + " ");
        }
    }

}
