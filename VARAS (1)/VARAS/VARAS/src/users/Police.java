package users;

import model.Accident;
import service.*;
import java.util.List;
import java.util.Scanner;

public class Police {
    private Scanner scanner;
    
    public void policeLogin(AccidentService accidentService, Scanner scanner) {
        this.scanner = scanner;
        
        System.out.println("\n=======================================================");
        System.out.println("              POLICE LOGIN");
        System.out.println("=======================================================");
        System.out.print("   Username: ");
        String username = scanner.nextLine();
        System.out.print("   Password: ");
        String password = scanner.nextLine();
        
        if (username.equals("police") && password.equals("123")) {
            System.out.println("\n  Login successful!");
            PoliceData.addPoliceLog("LOGIN SUCCESSFUL");
            policeDashboard(accidentService);
        } else {
            System.out.println("\n   Login failed! Invalid credentials.");
            PoliceData.addPoliceLog("LOGIN FAILED - User: " + username);
        }
    }
    
    private void policeDashboard(AccidentService accidentService) {
        while (true) {
            List<Accident> accidents = accidentService.getAllAccidents();
            
            if (accidents.isEmpty()) {
                System.out.println("\n═══════════════════════════════════════════════════════");
                System.out.println("               NO ACCIDENTS REPORTED YET!");
                System.out.println("═══════════════════════════════════════════════════════");
            } else {
                for (Accident accident : accidents) {
                    System.out.println(accident);
                }
            }
            
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║                      POLICE ACTION                  ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  1. Accept Case                                      ║");
            System.out.println("║  2. Reject Case                                      ║");
            System.out.println("║  3. Back                                             ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print("Enter choice: ");
            
            int choice = getIntInput();
            if (choice == 1) acceptCase(accidentService);
            else if (choice == 2) rejectCase(accidentService);
            else if (choice == 3) break;
        }
    }
    
    private void acceptCase(AccidentService accidentService) {
        System.out.print("\n  Enter Case ID: ");
        String caseId = scanner.nextLine();
        Accident accident = accidentService.findAccidentById(caseId);
        
        if (accident != null) {
            accident.setStatus("Accepted");
            accident.setPoliceAction("ACCEPTED");
            accidentService.saveAccidentsToFile();
            System.out.println("\n   Case accepted! Police on the way.");
            System.out.println("   Police dispatched to location.");
            System.out.println("  Traffic clearance in progress.");
            PoliceData.addPoliceLog("ACCEPTED CASE: " + caseId);
            SystemLog.log("Police ACCEPTED case: " + caseId);
        } else {
            System.out.println("\n   Case not found!");
        }
    }
    
    private void rejectCase(AccidentService accidentService) {
        System.out.print("\n  Enter Case ID: ");
        String caseId = scanner.nextLine();
        Accident accident = accidentService.findAccidentById(caseId);
        
        if (accident != null) {
            accident.setStatus("Rejected");
            accident.setPoliceAction("REJECTED");
            accidentService.saveAccidentsToFile();
            System.out.println("\n   Case rejected!");
            System.out.println("   Another unit will be notified.");
            PoliceData.addPoliceLog("REJECTED CASE: " + caseId);
            SystemLog.log("Police REJECTED case: " + caseId);
        } else {
            System.out.println("\n   Case not found!");
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