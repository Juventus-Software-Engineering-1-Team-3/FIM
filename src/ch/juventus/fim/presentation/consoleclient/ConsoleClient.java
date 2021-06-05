package ch.juventus.fim.presentation.consoleclient;

import java.util.Scanner;

import ch.juventus.fim.business.vehicle.Brand;
import ch.juventus.fim.business.vehicle.IVehicle;
import ch.juventus.fim.business.vehicle.IVehicleType;
import ch.juventus.fim.business.vehicle.VehicleFactory;
import ch.juventus.fim.business.vehicle.VehicleType;

public class ConsoleClient {

	// instance variables
	private static int vehicleId = 0;
	private static Brand brand = null;
	private static String model = null;
	private static String licensePlate = null;
	private static VehicleFactory vehicleFactory = null;
	private static IVehicle vehicle = null;

	public static void main(String[] args) {
		VehicleFactory vehicleFactory = VehicleFactory.getInstance();
		Scanner inputScan = new Scanner(System.in);

		// welcome message
		System.out.println("\t\t\tWillkommen zu");
		System.out.println("\t\t _______   __   __    __\r\n" + "\t\t|  _____| |  | |  \\  /  |\r\n"
				+ "\t\t|  |__    |  | |   \\/   |\r\n" + "\t\t|   __|   |  | |        |\r\n"
				+ "\t\t|  |      |  | |  |\\/|  |\r\n" + "\t\t|__|      |__| |__|  |__|");

		System.out.println("\n\n##### Menue: #####\n\n[1] Fahrzeug erfassen\n[2] Fahrzeug anzeigen"
				+ "\n\nBitte geben Sie eine Zahl ein!");

		int menuNum = Integer.parseInt(inputScan.nextLine());

		switch (menuNum) {
		case 1:
			createVehicle();
			break;
		case 2:
			findVehicle();
			break;
		// TODO: uncomment, when mainMenu method is implemented
		// default:
		// System.out.println("Bitte geben Sie eine gueltige Nummer ein!");
		// mainMenu();
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
			System.out.println("[" + (i + 1) + "] " + Brand.values()[i]);
		}

		System.out.println("\nBitte Marke auswaehlen!");
		brand = Brand.values()[Integer.parseInt(inputScan.nextLine()) - 1];
		System.out.println("\n*****************");

		System.out.println("\nModell:");
		model = inputScan.nextLine();
		System.out.println("\n*****************");

		System.out.println("\nNummernschild:");
		licensePlate = inputScan.nextLine();
		System.out.println("\n*****************");

		IVehicle vehicle = assembleVehicle();
		System.out.println("Fahrzeug erstellt!");
		displayVehicle(vehicle);
		saveVehicleDialog();

		System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
		inputScan.nextLine();

		System.out.println("Gehe zum Menue...");
		// TODO: uncomment, when mainMenu method is implemented
		// mainMenu();

		inputScan.close();
	}

	private static void findVehicle() {
		Scanner inputScan = new Scanner(System.in);

		System.out.println("\n\n##### Fahrzeug suchen #####");

		System.out.println("\nBitte Fahrzeug ID eingeben:");
		vehicleId = Integer.parseInt(inputScan.nextLine());

		displayVehicle(vehicleFactory.findVehicle(vehicleId));

		inputScan.close();
	}

	private static void displayVehicle(IVehicle vehicle) {
		System.out.println("Fahrzeug: " + vehicle.getVehicleId());
		System.out.println("Marke: " + vehicle.getVehicleType().getBrand().toString());
		System.out.println("Nummernschild: " + vehicle.getLicensePlate());
	}

	private static IVehicle assembleVehicle() {
		IVehicleType vehicleType = new VehicleType(brand, model);
		return vehicleFactory.createVehicle(vehicleId, licensePlate, vehicleType);
	}

	private static void saveVehicleDialog() {
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Moechten Sie das Fahrzeug speichern?\n[1] Ja\n[2] Nein\n");
		int mNum = Integer.parseInt(inputScan.nextLine());

		switch (mNum) {
			case 1:
				vehicleFactory.saveVehicle(vehicle);
				System.out.println("Fahrzeug gespeichert!");
				break;
			case 2:
				System.out.println("Fahrzeug wurde nicht gespeichert.");
				System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
				inputScan.nextLine();
			//	mainMenu();
				break;
			default:
				System.out.println("Bitte geben Sie eine gueltige Nummer ein!");
				saveVehicleDialog();
				break;
		}
		inputScan.close();
	}

}