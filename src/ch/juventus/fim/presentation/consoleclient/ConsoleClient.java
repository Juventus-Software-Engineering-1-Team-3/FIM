package ch.juventus.fim.presentation.consoleclient;

import java.util.Scanner;

public class ConsoleClient {
	// FIXME: workaround until enum brand is implemented
	private enum Brand {
		Mercedes,
		MAN
	}
	// instance variables
	public static int vehicleId;
	public static Brand brand;
	public static String model;
	public static String licensePlate;
	
	public static void main(String[] args) {
		
		// Scanner object for user input
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
				collectVehicleInformations();
				break;
			// TODO: implement displayVehicle() method
			//case 2:
			//	displayVehicle();
		}
		
		inputScan.close();
	}
	
	
	public static void collectVehicleInformations() {
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("\n\n##### Fahrzeug Erfassung #####");
		
		System.out.println("\nFahrzeug ID:");
		vehicleId = Integer.parseInt(inputScan.nextLine());
		System.out.println("\n*****************");
		
		for (int i = 0; i < Brand.values().length; i++) {
			System.out.println("["+(i+1)+"] "+Brand.values()[i]);
			}
		
		brand = Brand.values()[Integer.parseInt(inputScan.nextLine())-1];
		System.out.println("\n*****************");
		
		System.out.println("\nModell:");
		model = inputScan.nextLine();
		System.out.println("\n*****************");
		
		System.out.println("\nNummernschild:");
		licensePlate = inputScan.nextLine();
		System.out.println("\n*****************");
		
		System.out.println("\nVehicle created!");
		
		inputScan.close();
	}
	
}