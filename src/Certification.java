public class Certification {
    int certId;
    Cours cours;
    Etudiant etudiant;
    String dateObtention;

    public Certification(int certId, Cours cours, Etudiant etudiant) {
        this.certId = certId;
        this.cours = cours;
        this.etudiant = etudiant;
        this.dateObtention = Utilities.formatLocalDateTime();
    }

    public void afficherCertification() {
        System.out.println("certId : " + this.certId + " ");
        System.out.println("Nom de cours : " + cours.titre + " ");
        System.out.println("Nom d'etudiant : " + etudiant.nom + " ");
        System.out.println("La date d'obtention : " + dateObtention + " ");

    }

    public void estCertifiePourCours(int courseID) {
        if (this.certId == cours.courseId) {
            System.out.println("Vous avez deja prend un certificat pour ce cours");
        } else {
            System.out.println("Vous avez pas encore prend la certificat pour ce cours");
        }
    }

    public void genererCertification() {
        afficherCertification();
    }

}
