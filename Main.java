import java.util.Random;

public class Main {
	public static Integer generateRandomChiffre() {
		int min = 0;
		int max = 9;
		Random random = new Random();
		int randomNumber = random.nextInt(max - min + 1) + min;

		return randomNumber;
	}

	public static String generateminisicule() {
		int min = 97;
		int max = 122;
		Random random = new Random();
		int randomNumber = random.nextInt(max - min + 1) + min;
		String str = new Character((char) randomNumber).toString();
		return str;
	}

	public static String generateMajicule() {
		int min = 65;
		int max = 90;
		Random random = new Random();
		int randomNumber = random.nextInt(max - min + 1) + min;
		String str = new Character((char) randomNumber).toString();
		return str;
	}

	public static String generateSpeciaux() {
		int min = 33;
		int max = 47;
		Random random = new Random();
		int randomNumber = random.nextInt(max - min + 1) + min;
		String str = new Character((char) randomNumber).toString();
		return str;
	}

	public static String generateMotPasse(int taille_demande, Boolean chiffre, Boolean majiscule, Boolean speaciaux) {
		int taille_actulle = 0;
		String mot_de_passe = "";

		while (taille_actulle < taille_demande) {
			System.out.println("act:   *** " + taille_actulle);
			System.out.println("demande ***** " + taille_demande);

			mot_de_passe += generateminisicule();
			taille_actulle++;

			if (chiffre) {
				if (taille_actulle < taille_demande) {
					mot_de_passe += Integer.toString(generateRandomChiffre());
					taille_actulle++;
				}
			}

			if (majiscule) {
				if (taille_actulle < taille_demande) {
					mot_de_passe += generateMajicule();
					taille_actulle++;
				}
			}
			if (speaciaux) {
				if (taille_actulle < taille_demande) {
					mot_de_passe += generateSpeciaux();
					taille_actulle++;
				}
			}

		}

		return mot_de_passe;
	}

	public static void main(String[] args) {

		System.out.println("Le mot de passe est: " + generateMotPasse(7, true, true, true));

		/*
		 * int asciiVal = 97; String str = new Character((char) asciiVal).toString();
		 * System.out.println(str);
		 */

	}

}
