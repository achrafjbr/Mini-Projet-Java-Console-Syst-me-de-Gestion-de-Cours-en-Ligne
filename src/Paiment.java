import java.util.ArrayList;
import java.util.List;

public class Paiment {

    double montant;
    String datePaiement;
    String modePaiement;
    Etudiant etudiant;
    Cours cours;
    static List<Paiment> paiments = new ArrayList<>();

    public Paiment() {
    }

    public Paiment(double montant, String modePaiement, Cours cours, Etudiant etudiant) {
        this.montant = montant;
        this.datePaiement = Utilities.formatLocalDateTime();
        this.modePaiement = modePaiement;
        this.cours = cours;
        this.etudiant = etudiant;
    }

    public void effectuerPaiement(Paiment Paiment) {
        paiments.add(Paiment);
        System.out.println("Votre course a été acheté");
    }

    public boolean aPaye(Etudiant etudiant) {
        for (Paiment paiment : paiments) {
            if (etudiant.studentId == paiment.etudiant.studentId) {
                return true;
            }
        }
        return false;
    }
}
