import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculForceMdp {
    
    public static void main(String[] args) {
       


        // Utilisation de la fonction pour calculer la force d'un mot de passe
        String motDePasse = "azertyWXCVB1345@#()!";
        int force = calculerForceMotDePasse(motDePasse);


        // Calcul de la force des mots de passes
        // < 25 = pas fort
        // > 25 et < 50 = moyen
        // > 50 et < 75 = renforcé
        // > 75 = tres fort
        // 100 = irréprochable

        System.out.println("Force du mot de passe : " + force + " sur 100");
    }


    public static int calculerForceMotDePasse(String motDePasse) {
        int longueur = motDePasse.length();
        int points = 0;

        // Vérifier la longueur du mot de passe sur 20
        if (longueur < 6 ) {
            System.out.println(" ajout 5 - longeur");
            points += 5;
        } else if (longueur >= 6 && longueur < 10) {
            System.out.println(" ajout 10 - longeur");
            points += 10;
        } else if (longueur >= 10 && longueur < 15) {
            System.out.println(" ajout 15 - longeur");
            points += 15;
        } else if (longueur >= 15) {
            System.out.println(" ajout 20 - longeur");
            points += 20;
        }

        if(longueur > 5 ){
            // Vérifier si le mot de passe est unique (ne contient pas de caractères répétés) sur 20
            if (!motDePasse.matches(".*(.)(?=.*\\1).*")) {
                System.out.println(" ajout 20 - aucun repete");
                points += 20;
            }

        }

        // Vérifier la présence de caractères spéciaux sur 10
        if (motDePasse.matches(".*[!@#$%^&*(),.?:{}|<>].*")) {
            System.out.println(" ajout 10 presence carac spe");
            points += 10;
        }

        // Vérifier la présence de chiffres sur 10
        if (motDePasse.matches(".*\\d.*")) {
            System.out.println(" ajout 10 presence chiffre");
            points += 10;
        }

        // Vérifier la présence de lettres majuscules et minuscules sur 10
        if (motDePasse.matches(".*[a-z].*") && motDePasse.matches(".*[A-Z].*")) {
            System.out.println(" ajout 10 mini et maj");
            points += 20; // si il y a des minuscules et des majuscules
        } else if ((motDePasse.matches(".*[a-z].*") && !motDePasse.matches(".*[A-Z].*")) || (!motDePasse.matches(".*[a-z].*") && motDePasse.matches(".*[A-Z].*"))) {
            points += 10; // si il y a que des minuscules ou que des majuscules
            System.out.println(" ajout 10 seulement min et maj");
        }

        // Initialiser le compteur de caractères spéciaux à 0
        int nbCaracteresSpeciaux = 0;
        String regexCaracteresSpeciaux = "[!@#$%^&*(),.?:{}|<>]";
        Matcher matcher = Pattern.compile(regexCaracteresSpeciaux).matcher(motDePasse);
        while (matcher.find()) {
            nbCaracteresSpeciaux++;
        }

        // Vérifier si des correspondances ont été trouvées sur 20
        if (nbCaracteresSpeciaux > 0 && nbCaracteresSpeciaux < 2) {
            System.out.println(" ajout 5 - 1 spe");
            points += 5;
        } else if(nbCaracteresSpeciaux >= 2 && nbCaracteresSpeciaux < 5){
            System.out.println(" ajout 10 - 4 spe");
            points += 10;
        } else if (nbCaracteresSpeciaux >= 5){
            System.out.println(" ajout 20 - 6 spe");
            points += 20;
        }

        return points;
    }


    
}
