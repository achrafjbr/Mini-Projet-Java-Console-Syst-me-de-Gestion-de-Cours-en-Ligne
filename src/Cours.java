import java.util.ArrayList;
import java.util.List;

public class Cours {

    int courseId;
    String titre;
    String description;
    static List<Etudiant> etudiants = new ArrayList<>();
    Instructeur instructeur;
    static List<Instructeur> instructeurs = new ArrayList<>();

    public Cours() {
    }

    public Cours(int courseId, String titre, String description) {
        this.courseId = courseId;
        this.titre = titre;
        this.description = description;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        System.out.println("Mr : " + etudiant.nom + " your are login ");
    }

    public void ajouterInstructeur(Instructeur instructeur) {
        System.out.println("instID : " + instructeur.instructorId);
        instructeurs.add(instructeur);
        System.out.println("Mr : " + instructeur.nom + " your are login ");
    }

    public void assignerInstructeur(Instructeur instructeur) {
        this.instructeur = instructeur;
        System.out.println("This cours-> " + instructeur.cours.titre + " has been assigned to Instructor "
                + instructeur.nom + "  ");
    }

    public Instructeur getInstructeur(int instructeurId) {
        for (Instructeur inst : instructeurs) {
            if (inst.instructorId == instructeurId) {
                return inst;
            }
        }
        return null;
    }

    public void afficherDetails() {
        System.out.print("ce qu'ont inscrit dans les cours: ");
        for (int i = 0; i < etudiants.size(); i++) {
            System.out.println(" etudiantId :  " + etudiants.get(i).studentId + " ");
            System.out.println(" Nom :  " + etudiants.get(i).nom + " ");
            System.out.println(" Email :  " + etudiants.get(i).email + " ");
            for (Cours cours : etudiants.get(i).courses) {
                System.out.println(" coursId :  " + cours.courseId + " ");
                System.out.println(" Titre :  " + cours.titre + " ");
                System.out.println(" Description :  " + cours.description + " ");
            }
        }
    }

}
