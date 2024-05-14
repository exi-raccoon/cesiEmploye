package service;

import java.util.Scanner;

import business.IEmployeService;

public class MainMenu {
	// utilisation du scanner pour capter les input de la console
	private static final Scanner scanner = new Scanner(System.in);
	private static IEmployeService _employeService = new EmployeService();

	public static void mainMenu() {
		boolean running = true;
		while (running) {
			System.out.println("\n___ Main Menu ___");
			System.out.println("1/ Voir Employé");
			System.out.println("2/ Ajouter Employé");
			System.out.println("3/ Mettre à jour Employé");
			System.out.println("4/ Supprimer Employé");
			System.out.println("5/ Exit");
			System.out.print("Selectionnez une option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline left-over

			switch (option) {
			case 1:
				menuAfficherEmploye();
				break;
			case 2:
				menuAjouterEmploye();
				break;
			case 3:
				menuMAJEmploye();
				break;
			case 4:
				menuSupprimerEmploye();
				break;
			case 5:
				running = false;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void menuAfficherEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Afficher un employé ___");
			System.out.println("(tapez 0 pour revenir en arrière");
			System.out.print("Selectionnez un identifiant : ");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 0:
				back = true;
				break;
			default:
				_employeService.AfficherEmploye(option);
			}

		}
	}

	private static void menuAjouterEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Ajouter un employé ___");
			System.out.println("(tapez back pour revenir en arrière");
			System.out.print("Selectionnez un nom prénom : ");

			String option = scanner.nextLine();
			scanner.nextLine();

			switch (option) {
			case "back":
				back = true;
				break;
			default:
				System.out.println("Nom Prénom : ");
				String y = scanner.nextLine();
				System.out.println("Poste : ");
				String z = scanner.nextLine();
				System.out.println("Salaire : ");
				Double a = scanner.nextDouble();
				System.out.println("S'agit-il d'un poste actif ? f/t ");
				String b = scanner.nextLine();
				// pas besoin de taper False ou True, mais juste f ou t
				if (b.equals("f")) {
					Boolean boolActif = false;
					_employeService.AjouterEmploye(y, z, a, boolActif);
				} else {
					if (b.equals("t")) {
						Boolean boolActif = true;
						_employeService.AjouterEmploye(y, z, a, boolActif);
					}

				}
				break;

			}
		}
	}

	private static void menuMAJEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Ajouter un employé ___");
			System.out.println("(tapez 0 pour revenir en arrière");
			System.out.print("Selectionnez un identifiant : ");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 0:
				back = true;
				break;
			default:
				System.out.println("Nom Prénom : ");
				String y = scanner.nextLine();
				System.out.println("Poste : ");
				String z = scanner.nextLine();
				System.out.println("Salaire : ");
				Double a = scanner.nextDouble();
				System.out.println("S'agit-il d'un poste actif ? f/t ");
				String b = scanner.nextLine();
				// pas besoin de taper False ou True, mais juste f ou t
				if (b.equals("f")) {
					Boolean boolActif = false;
					_employeService.MAJEmploye(option, y, z, a, boolActif);
				} else {
					if (b.equals("t")) {
						Boolean boolActif = true;
						_employeService.MAJEmploye(option, y, z, a, boolActif);
					}

				}
				break;

			}
		}
	}

	private static void menuSupprimerEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Supprimer un employé ___");
			System.out.println("(tapez 0 pour revenir en arrière");
			System.out.print("Selectionnez un identifiant : ");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 0:
				back = true;
				break;
			default:
				_employeService.SupprimerEmploye(option);
			}

		}
	}
}
