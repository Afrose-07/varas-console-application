package main;

import java.util.Scanner;

import model.Accident;
import service.AccidentService;
import service.PoliceData;
import service.HospitalData;
import service.SystemLog;
import users.Admin;
import users.Police;
import users.Hospital;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AccidentService accidentService = new AccidentService();
    private static Admin admin = new Admin();
    private static Police police = new Police();
    private static Hospital hospital = new Hospital();
    
    public static void main(String[] args) {
        try {
            // Load all data
            PoliceData.loadFromFile();
            HospitalData.loadFromFile();
            accidentService.loadAllData();
            SystemLog.log("SYSTEM STARTED");
            
            System.out.println("=======================================================");
            System.out.println("     VEHICLE ACCIDENT RESPONSE SYSTEM");
            System.out.println("=======================================================");
            System.out.println("   Hospitals      : " + HospitalData.getHospitalCount());
            System.out.println("   Police Stations: " + PoliceData.getPoliceStationCount());
            System.out.println("   Accidents      : " + accidentService.getTotalAccidents());
            System.out.println("=======================================================");
            
            while (true) {
                displayMainMenu();
                int choice = getIntInput("  Enter your choice: ");
                
                switch (choice) {
                    case 1:
                        reportAccident();
                        break;
                    case 2:
                        police.policeLogin(accidentService, scanner);
                        break;
                    case 3:
                        hospital.hospitalLogin(accidentService, scanner);
                        break;
                    case 4:
                        admin.adminLogin(accidentService, scanner);
                        break;
                    case 5:
                        saveAndExit();
                        return;
                    default:
                        System.out.println("   Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(" System Error: " + e.getMessage());
            SystemLog.log("SYSTEM ERROR: " + e.getMessage());
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("              MAIN MENU");
        System.out.println("-------------------------------------------------------");
        System.out.println("  1.  Report Accident");
        System.out.println("  2.  Police Login");
        System.out.println("  3.  Hospital Login");
        System.out.println("  4.  Admin Login");
        System.out.println("  5.  Save & Exit");
        System.out.println("-------------------------------------------------------");
    }
    
    private static void reportAccident() {
        try {
            System.out.println("\n=======================================================");
            System.out.println("              REPORT ACCIDENT");
            System.out.println("=======================================================");
            
            String reporterName = getValidName();
            String vehicleNumber = getValidVehicleNumber();
            String district = getValidInput("   District: ");
            String town = getValidInput("   Town: ");
            String severity = getValidSeverity();
            
            // Check duplicate vehicle
            if (accidentService.isVehicleAlreadyReported(vehicleNumber)) {
                System.out.println("\nALREADY REPORTED! ");
                System.out.println("This vehicle number was already reported in an accident.");
                System.out.println("Thank you for your concern!");
                
                // Show existing accident details
                Accident existingAcc = accidentService.findAccidentByVehicle(vehicleNumber);
                if (existingAcc != null) {
                    System.out.println("\nExisting Accident Details:");
                    System.out.println("   Case ID: " + existingAcc.getAccidentId());
                    System.out.println("   Location: " + existingAcc.getLocation());
                    System.out.println("   Date: " + existingAcc.getDateOnly());
                    System.out.println("   Severity: " + existingAcc.getSeverity());
                    System.out.println("   Status: " + existingAcc.getStatus());
                    System.out.println("\nEmergency services are already handling this case.");
                }
                SystemLog.log("Duplicate report attempt for vehicle: " + vehicleNumber);
                return;
            }
            
            String accidentId = accidentService.generateAccidentId();
            String policeStation = PoliceData.getPoliceStation(district, town);
            String hospital = HospitalData.getHospital(district, town);
            
            Accident accident = new Accident(accidentId, vehicleNumber, reporterName, district, town, severity, policeStation, hospital);
            accidentService.addAccident(accident);
            
            System.out.println("\n=======================================================");
            System.out.println("  ACCIDENT REPORTED SUCCESSFULLY!");
            System.out.println("=======================================================");
            System.out.println("  Case ID        : " + accidentId);
            System.out.println("   Date & Time    : " + accident.getDateTime());
            System.out.println("   Location       : " + town + ", " + district);
            System.out.println("   Severity       : " + severity.toUpperCase());
            System.out.println("   Police Station : " + policeStation);
            System.out.println("   Hospital       : " + hospital);
            System.out.println("=======================================================");
            
            SystemLog.log("ACCIDENT REPORTED - Case: " + accidentId + " | Vehicle: " + vehicleNumber);
            PoliceData.addPoliceLog("NOTIFIED - Accident: " + accidentId + " at " + district + "/" + town);
            HospitalData.addHospitalLog("NOTIFIED - Accident: " + accidentId + " | Severity: " + severity);
            
        } catch (Exception e) {
            System.out.println(" Error reporting accident: " + e.getMessage());
            SystemLog.log("ERROR in reportAccident: " + e.getMessage());
        }
    }
    
    private static String getValidName() {
        while (true) {
            System.out.print("   Reporter Name (max 20 letters): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("   Name cannot be empty!");
            } else if (name.length() > 20) {
                System.out.println("   Name should not exceed 20 characters!");
            } else if (!name.matches("[a-zA-Z\\s]+")) {
                System.out.println("   Name should contain only letters!");
            } else {
                return name;
            }
        }
    }
    
    private static String getValidVehicleNumber() {
        while (true) {
            System.out.print("   Vehicle Number (Format: TN45BG6789): ");
            String vehicle = scanner.nextLine().toUpperCase().trim();
            if (vehicle.matches("TN[0-9]{2}[A-Z]{2}[0-9]{4}")) {
                return vehicle;
            } else {
                System.out.println("   Invalid Vehicle Number! Format must be TN45BG6789");
            }
        }
    }
    
    private static String getValidSeverity() {
        while (true) {
            System.out.print("   Severity (low/medium/high): ");
            String severity = scanner.nextLine().toLowerCase().trim();
            if (severity.equals("low") || severity.equals("medium") || severity.equals("high")) {
                return severity;
            } else {
                System.out.println("  Invalid severity! Please enter low, medium, or high");
            }
        }
    }
    
    private static String getValidInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    private static void saveAndExit() {
        try {
            accidentService.saveAllData();
            PoliceData.saveToFile();
            HospitalData.saveToFile();
            SystemLog.saveLogs();
            SystemLog.log("SYSTEM EXITED");
            System.out.println("\n  All data saved successfully!");
            System.out.println("  Thank you for using the system!");
            System.out.println("=======================================================");
        } catch (Exception e) {
            System.out.println(" Error saving data: " + e.getMessage());
        }
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("   Invalid input! Please enter a number.");
            }
        }
    }
}