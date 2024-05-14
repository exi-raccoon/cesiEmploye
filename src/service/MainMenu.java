package service;

import java.util.Scanner;

import business.IEmployeeService;
import business.IMainMenu;

public class MainMenu implements IMainMenu {
	// scanner allows to catch input in console
	private static final Scanner scanner = new Scanner(System.in);

	// inversion of dependencies between MainMenu and EmployeeService
	private static IEmployeeService _employeeService = new EmployeeService();

	// display in console the main menu
	// no parameter
	// void
	public void mainMenu() {
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

			switch (option) {
			case 1:
				menuDisplayEmploye();
				break;
			case 2:
				menuAddEmploye();
				break;
			case 3:
				menuUpdateEmploye();
				break;
			case 4:
				menuRemoveEmploye();
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

	// display in console the menu to choose to see the infos of which employee
	// no parameter
	// void
	private static void menuDisplayEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Afficher un employé ___");
			System.out.println("(tapez 0 pour revenir en arrière");
			System.out.print("Selectionnez un identifiant : ");

			int option = scanner.nextInt();

			switch (option) {
			case 0:
				back = true;
				break;
			default:
				_employeeService.DisplayEmployee(option);
			}

		}
	}

	// display in console the menu to add an employee
	// no parameter
	// void
	private static void menuAddEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Ajouter un employé ___");
			System.out.println("(tapez back pour revenir en arrière");
			System.out.print("Selectionnez un nom prénom : ");

			String option = scanner.nextLine();

			switch (option) {
			case "back":
				back = true;
				break;
			default:
				System.out.print("Poste : ");
				String z = scanner.nextLine();
				System.out.print("Salaire : ");
				int a = scanner.nextInt();
				System.out.print("S'agit-il d'un poste actif ? f/t ");
				String b = scanner.nextLine();
				b = scanner.nextLine();
				// pas besoin de taper False ou True, mais juste f ou t
				if (b.equals("f")) {
					Boolean boolActif = false;
					_employeeService.AddEmployee(option, z, a, boolActif);
				} else {
					if (b.equals("t")) {
						Boolean boolActif = true;
						_employeeService.AddEmployee(option, z, a, boolActif);
					}

				}
				break;

			}
			back = true;
		}
	}

	// display in console the menu to update an employee
	// no parameter
	// void
	private static void menuUpdateEmploye() {
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Mettre à jour un employé ___");
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
				int a = scanner.nextInt();
				System.out.println("S'agit-il d'un poste actif ? f/t ");
				String b = scanner.nextLine();
				b = scanner.nextLine();
				// pas besoin de taper False ou True, mais juste f ou t
				if (b.equals("f")) {
					Boolean boolActif = false;
					_employeeService.UpdateEmployee(option, y, z, a, boolActif);
				} else {
					if (b.equals("t")) {
						Boolean boolActif = true;
						_employeeService.UpdateEmployee(option, y, z, a, boolActif);
					}

				}
				break;

			}
		}
	}

	// display in console the menu to remove an employee
	// no parameter
	// void
	private static void menuRemoveEmploye() {
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
				_employeeService.RemoveEmployee(option);
			}

		}
	}
}
