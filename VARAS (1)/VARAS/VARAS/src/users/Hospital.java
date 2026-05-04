package users;

import model.Accident;
import service.*;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    private Scanner scanner;
    
    public void hospitalLogin(AccidentService accidentService, Scanner scanner) {
        this.scanner = scanner;
        
        System.out.println("\n=======================================================");
        System.out.println("              HOSPITAL LOGIN");
        System.out.println("=======================================================");
        System.out.print("   Username: ");
        String username = scanner.nextLine();
        System.out.print("   Password: ");
        String password = scanner.nextLine();
        
        if (username.equals("hospital") && password.equals("123")) {
            System.out.println("\n   Login successful!");
            HospitalData.addHospitalLog("LOGIN SUCCESSFUL");
            hospitalDashboard(accidentService);
        } else {
            System.out.println("\n   Login failed! Invalid credentials.");
            HospitalData.addHospitalLog("LOGIN FAILED - User: " + username);
        }
    }
    
    private void hospitalDashboard(AccidentService accidentService) {
        List<Accident> accidents = accidentService.getAcceptedAccidents();
        boolean hasEmergency = false;
        
        for (Accident accident : accidents) {
            if (!accident.isAmbulanceDispatched()) {
                hasEmergency = true;
                System.out.println("\n╔══════════════════════════════════════════════════════╗");
                System.out.println("║                    HOSPITAL EMERGENCY              ║");
                System.out.println("╠══════════════════════════════════════════════════════╣");
                System.out.println("║   EMERGENCY CASE: " + String.format("%-25s", accident.getAccidentId()) + "║");
                System.out.println("║   Location: " + String.format("%-30s", accident.getLocation()) + "║");
                System.out.println("║   Severity: " + String.format("%-30s", accident.getSeverity().toUpperCase()) + "║");
                System.out.println("║   Hospital: " + String.format("%-30s", accident.getHospital()) + "║");
                System.out.println("║   Reporter: " + String.format("%-30s", accident.getReporterName()) + "║");
                System.out.println("║   Vehicle: " + String.format("%-30s", accident.getVehicleNumber()) + "║");
                System.out.println("╠══════════════════════════════════════════════════════╣");
                System.out.println("║                      HOSPITAL ACTION               ║");
                System.out.println("╠══════════════════════════════════════════════════════╣");
                System.out.println("║  1. Dispatch Ambulance                              ║");
                System.out.println("║  2. Prepare Emergency Room                          ║");
                System.out.println("║  3. Back                                            ║");
                System.out.println("╚══════════════════════════════════════════════════════╝");
                System.out.print("Enter choice: ");
                
                int choice = getIntInput();
                if (choice == 1) {
                    accident.setAmbulanceDispatched(true);
                    accident.setAmbulanceStatus("ON THE WAY");
                    accidentService.saveAccidentsToFile();
                    System.out.println("\n   Ambulance Dispatched!");
                    System.out.println("     Medical staff on the way.");
                    System.out.println("     Emergency room ready.");
                    HospitalData.addHospitalLog("DISPATCHED AMBULANCE for case: " + accident.getAccidentId());
                    SystemLog.log("Ambulance dispatched for case: " + accident.getAccidentId());
                } else if (choice == 2) {
                    System.out.println("\n  Emergency room prepared!");
                    HospitalData.addHospitalLog("PREPARED EMERGENCY ROOM for case: " + accident.getAccidentId());
                } else {
                    break;
                }
            }
        }
        
        if (!hasEmergency) {
            System.out.println("\n═══════════════════════════════════════════════════════");
            System.out.println("              NO EMERGENCY CASES");
            System.out.println("═══════════════════════════════════════════════════════");
        }
    }
    
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("   Invalid input! Enter a number: ");
            }
        }
    }
}