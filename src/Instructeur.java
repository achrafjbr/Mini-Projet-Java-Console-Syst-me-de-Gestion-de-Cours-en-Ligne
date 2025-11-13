
public class Instructeur {

    int instructorId;
    String nom;
    String specialisation;
    Cours cours;

    public Instructeur(int instructorId, String specialisation, String nom) {
        this.instructorId = instructorId;
        this.specialisation = specialisation;
        this.nom = nom;
    }

    public void assignerCours(Cours cours, Etudiant etudiant) {
        for (Etudiant etd : Cours.etudiants) {
            if (etudiant.studentId == etd.studentId) {
                etudiant.courses.add(cours);
                System.out.println("Assignment has been done");
                return;
            }
        }
    }

    public void afficherCours() {
        System.out.println("Cours Id : " + cours.courseId + " ");
        System.out.println("Cours Title : " + cours.titre + " ");
        System.out.println("Cours Description : " + cours.description + " ");
    }

}
