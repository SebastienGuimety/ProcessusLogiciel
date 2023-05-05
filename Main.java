package ProcessusLogiciel;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static String genererFaibleMotDepasse(Boolean chiffre, Boolean speciaux) {

		int min = 1;
		int max = 5;
		Random random = new Random();
		int taille_exige = random.nextInt(max - min + 1) + min;
		String mot_de_passe = "";
		int taille_actulle = 0;
		String temp = "";
		while (taille_actulle < taille_exige) {

			System.out.println("act:   *** " + taille_actulle);
			System.out.println("demande ***** " + taille_exige);
			temp = generateminisicule();
			mot_de_passe += temp;

			taille_actulle++;

			if (chiffre) {
				if (taille_actulle < taille_exige) {
					temp = Integer.toString(generateRandomChiffre());
					mot_de_passe += temp;
					taille_actulle++;
				}
			}

			if (speciaux) {
				if (taille_actulle < taille_exige) {
					temp = generateSpeciaux();
					mot_de_passe += temp;
					taille_actulle++;
				}
			}
		}

		mot_de_passe += temp;
		System.out.println("le nouveau mot de passe est " + mot_de_passe);

		System.out.println("force mdp est " + calculerForceMotDePasse(mot_de_passe));

		return "";
	}

	public static String generateMotPasseMoyen(Boolean chiffre, Boolean speciaux) {
		int min = 6;
		int max = 10;
		Random random = new Random();
		int taille_exige = random.nextInt(max - min + 1) + min;
		String mot_de_passe = "";
		int taille_actulle = 0;
		String temp = "";
		while (taille_actulle < taille_exige) {

			System.out.println("act:   *** " + taille_actulle);
			System.out.println("demande ***** " + taille_exige);
			temp = generateminisicule();
			if (taille_actulle < taille_exige) {
				mot_de_passe += temp;
				taille_actulle++;
			}

			if (chiffre) {
				if (taille_actulle < taille_exige) {
					temp = Integer.toString(generateRandomChiffre());
					mot_de_passe += temp;
					taille_actulle++;
					if (taille_actulle < taille_exige) {
						mot_de_passe += temp;
						taille_actulle++;
					}
				}
			}

			if (speciaux) {
				if (taille_actulle < taille_exige) {
					temp = generateSpeciaux();
					if (taille_actulle < taille_exige) {
						mot_de_passe += temp;
						taille_actulle++;
					}
					if (taille_actulle < taille_exige) {
						mot_de_passe += temp;
						taille_actulle++;
					}
				}
			}

		}
		System.out.println("*** le mdp est : " + mot_de_passe);
		System.out.println("force mdp est  " + calculerForceMotDePasse(mot_de_passe));
		return "";

	}

	public static String generateMotPasseRenforce(Boolean chiffre, Boolean speciaux, Boolean majisucle) {
		int min = 10;
		int max = 15;
		Random random = new Random();
		int taille_exige = random.nextInt(max - min + 1) + min;
		String mot_de_passe = "";
		int taille_actulle = 0;
		String temp = "";
		while (taille_actulle < taille_exige) {

			System.out.println("act:   *** " + taille_actulle);
			System.out.println("demande ***** " + taille_exige);
			temp = generateminisicule();
			if (taille_actulle < taille_exige) {
				mot_de_passe += temp;
				taille_actulle++;
			}

			if (chiffre) {
				if (taille_actulle < taille_exige) {
					temp = Integer.toString(generateRandomChiffre());
					mot_de_passe += temp;
					taille_actulle++;
					if (taille_actulle < taille_exige) {
						mot_de_passe += temp;
						taille_actulle++;
					}
				}
			}

			if (speciaux) {
				if (taille_actulle < taille_exige) {
					temp = generateSpeciaux();

					mot_de_passe += temp;
					taille_actulle++;
					if (taille_actulle < taille_exige) {
						mot_de_passe += temp;
						taille_actulle++;
					}
				}
			}
			if (majisucle) {
				temp = generateMajicule();
				mot_de_passe += temp;
				taille_actulle++;
			}

		}
		System.out.println("*** le mdp est : " + mot_de_passe);
		System.out.println("force mdp est  " + calculerForceMotDePasse(mot_de_passe));
		return "";

	}

	public static String generateMotPasseFort(Boolean chiffre, Boolean speciaux, Boolean majisucle) {
		int min = 15;
		int max = 20;
		Random random = new Random();
		int taille_exige = random.nextInt(max - min + 1) + min;
		String mot_de_passe = "";
		int taille_actulle = 0;
		String temp = "";
		while (taille_actulle < taille_exige) {

			System.out.println("act:   *** " + taille_actulle);
			System.out.println("demande ***** " + taille_exige);
			temp = generateminisicule();
			String temp_test = "";
			
			if (taille_actulle < taille_exige) {
				
				temp_test += temp;
				if (!temp_test.matches(".*(.)(?=.*\\1).*")) {
					mot_de_passe += temp;
					taille_actulle++;
					
				}
				
				
			}

			if (chiffre) {
				if (taille_actulle < taille_exige) {
					temp = Integer.toString(generateRandomChiffre());
					mot_de_passe += temp;
					taille_actulle++;

				}
			}

			if (speciaux) {
				if (taille_actulle < taille_exige) {
					temp = generateSpeciaux();
					temp_test += temp;
					if (!temp_test.matches(".*(.)(?=.*\\1).*")) {
					mot_de_passe += temp;
					taille_actulle++;
					}
				}
			}
			if (majisucle) {
				temp = generateMajicule();
				temp_test += temp;
				if (!temp_test.matches(".*(.)(?=.*\\1).*")) {
					mot_de_passe += temp;
					taille_actulle++;
				}
			}

		}
		System.out.println("*** le mdp est : " + mot_de_passe);
		System.out.println("force mdp est  " + calculerForceMotDePasse(mot_de_passe));
		return "";

	}

	public static int calculerForceMotDePasse(String motDePasse) {
		int longueur = motDePasse.length();
		int points = 0;

		// Vérifier la longueur du mot de passe sur 20
		if (longueur <= 6) {
			System.out.println(" ajout 5 - longeur");
			points += 5;
		} else if (longueur > 6 && longueur < 10) {
			System.out.println(" ajout 10 - longeur");
			points += 10;
		} else if (longueur >= 10 && longueur < 15) {
			System.out.println(" ajout 15 - longeur");
			points += 15;
		} else if (longueur >= 15) {
			System.out.println(" ajout 20 - longeur");
			points += 25;
		}

		if (longueur >= 5) {
			// Vérifier si le mot de passe est unique (ne contient pas de caractères
			// répétés) sur 20
			if (!motDePasse.matches(".*(.)(?=.*\\1).*")) {
				System.out.println(" ajout 25 - aucun repete");
				points += 25;
			}

		}

		// Vérifier la présence de chiffres sur 10
		if (motDePasse.matches(".*\\d.*")) {
			System.out.println(" ajout 10 presence chiffre");
			points += 10;
		}

		if (motDePasse.matches(".*[A-Z].*")) {
			System.out.println(" ajout 10 pr�sence Majisucule");
			points += 10;
		}
		// Vérifier la présence de lettres majuscules et minuscules sur 10
		if (motDePasse.matches(".*[a-z].*") && motDePasse.matches(".*[A-Z].*")) {
			System.out.println(" ajout 10 mini et maj");
			points += 20; // si il y a des minuscules et des majuscules
		} else if ((motDePasse.matches(".*[a-z].*") && !motDePasse.matches(".*[A-Z].*"))
				|| (!motDePasse.matches(".*[a-z].*") && motDePasse.matches(".*[A-Z].*"))) {
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
		} else if (nbCaracteresSpeciaux >= 2 && nbCaracteresSpeciaux < 5) {
			System.out.println(" ajout 10 - 4 spe");
			points += 10;
		} else if (nbCaracteresSpeciaux >= 5) {
			System.out.println(" ajout 20 > 5 spe");
			points += 20;
		}

		return points;
	}

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

		// System.out.println("Le mot de passe est: " + generateMotPasse(7, true, true,
		// true));

		String motDePasse = "azer112";
		// System.out.println("Force du mot de passe : " + force + " sur 100");
		// genererFaibleMotDepasse(true, false);
		// generateMotPasseMoyen(true, true);
		// generateMotPasseRenforce(true, true,true);
		generateMotPasseFort(true, true, true);
		/*
		 * int asciiVal = 97; String str = new Character((char) asciiVal).toString();
		 * System.out.println(str);
		 */

	}

}
