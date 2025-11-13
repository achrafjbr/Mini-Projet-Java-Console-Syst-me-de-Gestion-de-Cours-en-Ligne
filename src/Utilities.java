import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    static public String formatLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return localDateTime.format(dateTimeFormatter);
    }


    static public Etudiant getStudentById(int studentId) {
        for (Etudiant etudiant : Cours.etudiants) {
            if (etudiant.studentId == studentId) {
                return etudiant;
            }
        }
        return null;
    }

    static public Cours getCoursById(int coursId) {
        for (Cours cours : Etudiant.courses) {
            if (cours.courseId == coursId) {
                return cours;
            }
        }
        return null;
    }


}
