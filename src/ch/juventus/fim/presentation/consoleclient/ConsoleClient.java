/**
 * Console Client class
 */

package ch.juventus.fim.presentation.consoleclient;

import java.time.LocalDateTime;
import java.util.Scanner;

import ch.juventus.fim.business.logentry.ILogEntry;
import ch.juventus.fim.business.logentry.LogEntryFactory;
import ch.juventus.fim.business.logentry.LogEntryShiftEnd;
import ch.juventus.fim.business.logentry.LogEntryShiftStart;
import ch.juventus.fim.business.logentry.OilLevel;
import ch.juventus.fim.business.logentry.TirePressure;
import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.business.vehicle.Brand;
import ch.juventus.fim.business.vehicle.IVehicle;
import ch.juventus.fim.business.vehicle.IVehicleType;
import ch.juventus.fim.business.vehicle.VehicleFactory;
import ch.juventus.fim.business.vehicle.VehicleType;

public class ConsoleClient {

	// Initialization of instance variables
	private VehicleFactory vehicleFactory = null;
	private LogEntryFactory logEntryFactory = null;
	private StaffFactory staffFactory = null;
	private Scanner inputScan = null;

	// Default Constructor
	public ConsoleClient() {
		vehicleFactory = VehicleFactory.getInstance();
		logEntryFactory = LogEntryFactory.getInstance();
		staffFactory = StaffFactory.getInstance();
		inputScan = new Scanner(System.in);
	}

	public void mainMenu() {
		// welcome message
		System.out.println("\t\t\tWillkommen zu");
		System.out.println("\t\t _______   __   __    __\r\n" + "\t\t|  _____| |  | |  \\  /  |\r\n"
				+ "\t\t|  |__    |  | |   \\/   |\r\n" + "\t\t|   __|   |  | |        |\r\n"
				+ "\t\t|  |      |  | |  |\\/|  |\r\n" + "\t\t|__|      |__| |__|  |__|");

		System.out.println("\n\n##### Menue: #####\n\n[1] Fahrzeug erfassen\n[2] Fahrzeug anzeigen\n[3] Log Eintrag anzeigen"
				+ "\n\nBitte geben Sie eine Zahl ein!");

		int menuNum = Integer.parseInt(inputScan.nextLine());

		switch (menuNum) {
		case 1:
			createVehicle();
			break;
		case 2:
			findVehicle();
			break;
		case 3:
			findLogEntry();
			break;
		default:
			System.out.println("Bitte geben Sie eine gueltige Nummer ein!");
			mainMenu();
		}

	}

	public void close() {
		System.out.println("\n\nGoodbye!");
		inputScan.close();
	}

	private void createVehicle() {
		System.out.println("\n\n##### Fahrzeug Erfassung #####");

		System.out.println("\nFahrzeug ID:");
		int vehicleId = Integer.parseInt(inputScan.nextLine());
		System.out.println("\n*****************");

		for (int i = 0; i < Brand.values().length; i++) {
			System.out.println("[" + (i + 1) + "] " + Brand.values()[i]);
		}

		System.out.println("\nBitte Marke auswaehlen!");
		Brand brand = Brand.values()[Integer.parseInt(inputScan.nextLine()) - 1];
		System.out.println("\n*****************");

		System.out.println("\nModell:");
		String model = inputScan.nextLine();
		System.out.println("\n*****************");

		System.out.println("\nNummernschild:");
		String licensePlate = inputScan.nextLine();
		System.out.println("\n*****************");

		IVehicle vehicle = assembleVehicle(vehicleId, brand, model, licensePlate);
		System.out.println("Fahrzeug erstellt!");
		displayVehicle(vehicle);
		saveVehicleDialog(vehicle);

		System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
		inputScan.nextLine();

		System.out.println("Gehe zum Menue...");
		mainMenu();

	}

	private void findVehicle() {
		System.out.println("\n\n##### Fahrzeug suchen #####");

		System.out.println("\nBitte Fahrzeug ID eingeben:");
		int vehicleId = Integer.parseInt(inputScan.nextLine());

		IVehicle vehicle = vehicleFactory.findVehicle(vehicleId);

		displayVehicle(vehicle);

		System.out.println("\n[1] Zurueck\n[2] Log Eintrag Schichtstart" + "\n\nBitte geben Sie eine Zahl ein!");

		int mNum = Integer.parseInt(inputScan.nextLine());

		switch (mNum) {
		case 1:
			mainMenu();
			break;
		case 2:
			gatherLogEntry(vehicle);
			break;
		default:
			mainMenu();
			break;
		}

	}
	
	private void findLogEntry() {
		System.out.println("\n\n##### Log Eintrag suchen #####");

		System.out.println("\nBitte Eintragsnummer eingeben:");
		int logEntryId = Integer.parseInt(inputScan.nextLine());

		ILogEntry logEntry = logEntryFactory.findLogEntry(logEntryId);

		displayLogEntry(logEntry);

		System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
		inputScan.nextLine();

		System.out.println("Gehe zum Menue...");
		mainMenu();

	}

	private void gatherLogEntry(IVehicle vehicle) {
		System.out.println("\n\nLog Eintrag erfassen\n\n");

		System.out.println("\nEintragsnummer:");
		int logEntryId = Integer.parseInt(inputScan.nextLine());
		System.out.println("\n*****************");

		System.out.println("\nKommentar:");
		String remarks = inputScan.nextLine();
		System.out.println("\n*****************");

		System.out.println("\nAuthor:");
		int staffId = Integer.parseInt(inputScan.nextLine());
		System.out.println("\n*****************");

		System.out.println("\nOelstand:");
		System.out.println("\n[1] Zu hoch\n[2] Zu tief\n[3] Gut" + "\n\nBitte geben Sie eine Zahl ein!");
		OilLevel oilLevel = OilLevel.values()[Integer.parseInt(inputScan.nextLine()) - 1];
		System.out.println("\n*****************");

		System.out.println("\nReifendruck:");
		System.out.println("\n[1] Zu hoch\n[2] Zu tief\n[3] Gut" + "\n\nBitte geben Sie eine Zahl ein!");
		TirePressure tirePressure = TirePressure.values()[Integer.parseInt(inputScan.nextLine()) - 1];
		System.out.println("\n*****************");

		ILogEntry logEntry = assembleLogEntry(logEntryId, remarks, staffId, oilLevel, tirePressure);

		displayLogEntry(logEntry);

		saveLogEntryDialog(vehicle, logEntry);
		
		System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
		inputScan.nextLine();

		System.out.println("Gehe zum Menue...");
		mainMenu();

	}

	private void displayLogEntry(ILogEntry logEntry) {

		System.out.println("\nEintragsnummer: " + String.valueOf(logEntry.getLogEntryId()));

		System.out.println("Kommentar: " + logEntry.getRemarks());

		System.out.println("Author: " + logEntry.getStaff().getName() + " " + logEntry.getStaff().getSurname());

		if (logEntry instanceof LogEntryShiftStart) {
			LogEntryShiftStart logEntryShiftStart = (LogEntryShiftStart) logEntry;

			System.out.println("Oelstand: " + logEntryShiftStart.getOilLevel().toString());

			System.out.println("Reifendruck: " + logEntryShiftStart.getTirePressure().toString() + "\n");
		}

		if (logEntry instanceof LogEntryShiftEnd) {
			// TODO: show shift end specific values
		}

	}

	private ILogEntry assembleLogEntry(int logEntryId, String remarks, int staffId, OilLevel oilLevel,
			TirePressure tirePressure) {
		IStaff staff = staffFactory.findStaff(staffId);
		return logEntryFactory.createLogEntry(logEntryId, remarks, staff, LocalDateTime.now(), oilLevel, tirePressure);
	}

	private void saveLogEntryDialog(IVehicle vehicle, ILogEntry logEntry) {
		System.out.println("Moechten Sie den Eintrag speichern?\n[1] Ja\n[2] Nein \n");
		int mNum = Integer.parseInt(inputScan.nextLine());

		switch (mNum) {
		case 1:
			logEntryFactory.saveLogEntry(logEntry);
			vehicle.addLogEntry(logEntry);
			vehicleFactory.saveVehicle(vehicle);
			System.out.println("Eintrag wurde gespeichert!");
			break;
		case 2:
			System.out.println("Eintrag wurde nicht gespeichert.");
			System.out.println("[<==] Druecken Sie eine bliebige Taste um zum Menue zurueckzukehren...");
			inputScan.nextLine();
			mainMenu();
			break;
		default:
			System.out.println("Bitte geben Sie eine gueltige Nummer ein!");
			saveLogEntryDialog(vehicle, logEntry);
			break;
		}
	}

	private void displayVehicle(IVehicle vehicle) {
		System.out.println("\nFahrzeug: " + vehicle.getVehicleId());
		System.out.println("Marke: " + vehicle.getVehicleType().getBrand().toString());
		System.out.println("Nummernschild: " + vehicle.getLicensePlate() + "\n");
	}

	private IVehicle assembleVehicle(int vehicleId, Brand brand, String model, String licensePlate) {
		IVehicleType vehicleType = new VehicleType(brand, model);
		return vehicleFactory.createVehicle(vehicleId, licensePlate, vehicleType);
	}

	private void saveVehicleDialog(IVehicle vehicle) {
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
			mainMenu();
			break;
		default:
			System.out.println("Bitte geben Sie eine gueltige Nummer ein!");
			saveVehicleDialog(vehicle);
			break;
		}
	}

}