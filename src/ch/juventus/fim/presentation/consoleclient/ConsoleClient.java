package ch.juventus.fim.presentation.consoleclient;

import java.util.Scanner;

public class ConsoleClient {
	// FIXME: workaround until enum brand is implemented
	private enum Brand {
		Mercedes,
		MAN
	}
	// instance variables
	private static int vehicleId;
	private static Brand brand;
	private static String model;
	private static String licensePlate;
	
	public static void main(String[] args) {
		
		Scanner inputScan = new Scanner(System.in);
		
		// welcome message
		System.out.println("\t\t\tWillkommen zu");
		System.out.println("\t\t _______   __   __    __\r\n"
				+ "\t\t|  _____| |  | |  \\  /  |\r\n"
				+ "\t\t|  |__    |  | |   \\/   |\r\n"
				+ "\t\t|   __|   |  | |        |\r\n"
				+ "\t\t|  |      |  | |  |\\/|  |\r\n"
				+ "\t\t|__|      |__| |__|  |__|");
		
		System.out.println("\n\n##### Menü: #####\n\n[1] Fahrzeug erfassen\n[2] Fahrzeug anzeigen"
				+ "\n\nBitte geben Sie eine Zahl ein!");
		
		int menuNum = Integer.parseInt(inputScan.nextLine());
		
		switch (menuNum) {
			case 1:
				createVehicle();
				break;
			// TODO: implement displayVehicle() method
			//case 2:
			//	findVehicle();
			// TODO: uncomment, when mainMenu method is implemented
			//default:
			//	System.out.println("Bitte geben Sie eine gültige Nummer ein!");
			//	mainMenu();
		}
		
		inputScan.close();
	}
	
	
	private static void createVehicle() {
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("\n\n##### Fahrzeug Erfassung #####");
		
		System.out.println("\nFahrzeug ID:");
		vehicleId = Integer.parseInt(inputScan.nextLine());
		System.out.println("\n*****************");
		
		for (int i = 0; i < Brand.values().length; i++) {
			System.out.println("["+(i+1)+"] "+Brand.values()[i]);
		}
		
		System.out.println("\nBitte Marke auswählen!");
		brand = Brand.values()[Integer.parseInt(inputScan.nextLine())-1];
		System.out.println("\n*****************");
		
		System.out.println("\nModell:");
		model = inputScan.nextLine();
		System.out.println("\n*****************");
		
		System.out.println("\nNummernschild:");
		licensePlate = inputScan.nextLine();
		System.out.println("\n*****************");
		
		// TODO: uncomment, whenever VehicleFactory is implemented
		// VehicleFactory vehicleFactory = vehicleFactory.getInstance();
		// IVehicle vehicle = vehicleFactory.createVehicle(vehicleId, brand, model, licensePlate);
		
		System.out.println("\nVehicle created!\n*****************\n");
		
		System.out.println("[<==] Drücken Sie eine bliebige Taste um zum Menü zurückzukehren...");
		inputScan.nextLine();
		
		// Test message
		System.out.println("Gehe zum Menü...");
		// TODO: uncomment, when mainMenu method is implemented
		// mainMenu();
		
		inputScan.close();
	}
	
	// TODO: uncomment, whenever VehicleFactory is implemented
	/*private static void findVehicle() {
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("\n\n##### Fahrzeug suchen #####");
		
		System.out.println("\nBitte Fahrzeug ID eingeben:");
		vehicleId = Integer.parseInt(inputScan.nextLine());
		
		VehicleFactory vehicleFactory = vehicleFactory.getInstance();
		IVehicle vehicle = vehicleFactory.findVehicle(vehicleId);
		
		inputScan.close();
		
	}*/
	
}