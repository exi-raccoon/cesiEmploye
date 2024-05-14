package app;

import business.IMainMenu;
import service.MainMenu;

public class Launcher {

	public static void main(String[] args) {
		final IMainMenu _menu = new MainMenu();
		_menu.mainMenu();
	}

}
