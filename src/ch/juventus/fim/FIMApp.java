package ch.juventus.fim;

import ch.juventus.fim.presentation.consoleclient.ConsoleClient;
import ch.juventus.fim.presentation.consoleclient.SeedData;

public class FIMApp {

	public static void main(String[] args) {
		SeedData seed = new SeedData();

		seed.createStaff();

		ConsoleClient client = new ConsoleClient();
		client.mainMenu();
	}

}
