/**
 * FIM Application class to run the Application
 */

package ch.juventus.fim;

import ch.juventus.fim.presentation.consoleclient.ConsoleClient;
import ch.juventus.fim.presentation.consoleclient.SeedData;

public class FIMApp {
	
	// main method
	public static void main(String[] args) {
		
		// Create new Seed Data Object
		SeedData seed = new SeedData();
		
		// Fill up the Seed Data Object with Staff entries
		seed.createStaff();
		
		// Create new Console Client Object and call the Main Menu
		ConsoleClient client = new ConsoleClient();
		client.mainMenu();
	}

}
