package app;

import business.IMainMenu;
import service.MainMenu;

public class Launcher {

	public static void main(String[] args) {
		// inversion of dependencies between MainMenu (service) and Launcher
		final IMainMenu _menu = new MainMenu();

		// display the menu in console
		_menu.mainMenu();
	}

}
