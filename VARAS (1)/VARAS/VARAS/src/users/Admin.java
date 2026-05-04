package users;

import model.Accident;
import service.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Admin {
    private Scanner scanner;
    
    public void adminLogin(AccidentService accidentService, Scanner scanner) {
        this.scanner = scanner;
        
        System.out.println("\n=======================================================");
        System.out.println("              ADMIN LOGIN");
        System.out.println("=======================================================");
        System.out.print("   Username: ");
        String username = scanner.nextLine();
        System.out.print("   Password: ");
        String password = scanner.nextLine();
        
        if (username.equals("admin") && password.equals("123")) {
            System.out.println("\n   Login successful!");
            SystemLog.log("ADMIN LOGIN SUCCESSFUL");
            adminDashboard(accidentService);
        } else {
            System.out.println("\n   Login failed! Invalid credentials.");
            SystemLog.log("ADMIN LOGIN FAILED - User: " + username);
        }
    }
    
    private void adminDashboard(AccidentService accidentService) {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║                       ADMIN DASHBOARD               ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  1. View All Accidents                               ║");
            System.out.println("║  2. Search Accidents by Date                         ║");
            System.out.println("║  3. Search Accidents by Date Range                   ║");
            System.out.println("║  4. View Statistics                                  ║");
            System.out.println("║  5. Manage Hospitals                                 ║");
            System.out.println("║  6. Manage Police Stations                           ║");
            System.out.println("║  7. View Police Log                                  ║");
            System.out.println("║  8. View Hospital Log                                ║");
            System.out.println("║  9. View System Log                                  ║");
            System.out.println("║ 10. Back to Main Menu                                ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print("Enter choice: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    viewAllAccidents(accidentService);
                    break;
                case 2:
                    searchByDate(accidentService);
                    break;
                case 3:
                    searchByDateRange(accidentService);
                    break;
                case 4:
                    viewStatistics(accidentService);
                    break;
                case 5:
                    manageHospitals();
                    break;
                case 6:
                    managePoliceStations();
                    break;
                case 7:
                    PoliceData.viewPoliceLog();
                    break;
                case 8:
                    HospitalData.viewHospitalLog();
                    break;
                case 9:
                    SystemLog.viewSystemLog();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("   Invalid choice!");
            }
        }
    }
    
    // ========== NEW: SEARCH ACCIDENTS BY SPECIFIC DATE ==========
    private void searchByDate(AccidentService accidentService) {
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("               SEARCH ACCIDENTS BY DATE");
        System.out.println("═══════════════════════════════════════════════════════");
        
        // Show available dates
        Set<String> availableDates = accidentService.getAllAccidentDates();
        if (availableDates.isEmpty()) {
            System.out.println("   No accidents reported yet!");
            return;
        }
        
        System.out.println("\n   Available Dates:");
        for (String date : availableDates) {
            System.out.println("     - " + date);
        }
        
        System.out.print("\n  Enter Date (YYYY-MM-DD): ");
        String searchDate = scanner.nextLine().trim();
        
        List<Accident> results = accidentService.searchAccidentsByDate(searchDate);
        
        if (results.isEmpty()) {
            System.out.println("\n   No accidents found on " + searchDate);
            System.out.println("   Tip: Check the available dates listed above.");
        } else {
            System.out.println("\n═══════════════════════════════════════════════════════");
            System.out.println("  ACCIDENTS ON " + searchDate + " (Total: " + results.size() + ")");
            System.out.println("═══════════════════════════════════════════════════════");
            for (Accident accident : results) {
                System.out.println(accident);
            }
        }
        SystemLog.log("ADMIN: SEARCHED ACCIDENTS BY DATE - " + searchDate);
    }
    
    // ========== NEW: SEARCH ACCIDENTS BY DATE RANGE ==========
    private void searchByDateRange(AccidentService accidentService) {
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("           🔍 SEARCH ACCIDENTS BY DATE RANGE");
        System.out.println("═══════════════════════════════════════════════════════");
        
        System.out.print("\n  Enter Start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine().trim();
        System.out.print("  Enter End Date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine().trim();
        
        List<Accident> results = accidentService.searchAccidentsByDateRange(startDate, endDate);
        
        if (results.isEmpty()) {
            System.out.println("\n   No accidents found between " + startDate + " and " + endDate);
        } else {
            System.out.println("\n═══════════════════════════════════════════════════════");
            System.out.println("   ACCIDENTS FROM " + startDate + " TO " + endDate + " (Total: " + results.size() + ")");
            System.out.println("═══════════════════════════════════════════════════════");
            
            // Group by date for better display
            Map<String, List<Accident>> groupedByDate = new LinkedHashMap<>();
            for (Accident accident : results) {
                String date = accident.getDateOnly();
                groupedByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(accident);
            }
            
            for (Map.Entry<String, List<Accident>> entry : groupedByDate.entrySet()) {
                System.out.println("\n DATE: " + entry.getKey() + " (" + entry.getValue().size() + " accidents)");
                System.out.println("───────────────────────────────────────────────────");
                for (Accident accident : entry.getValue()) {
                    System.out.println("   Case ID: " + accident.getAccidentId());
                    System.out.println("     Location: " + accident.getLocation());
                    System.out.println("     Vehicle: " + accident.getVehicleNumber());
                    System.out.println("     Severity: " + accident.getSeverity().toUpperCase());
                    System.out.println("     Status: " + accident.getStatus());
                    System.out.println("     Reporter: " + accident.getReporterName());
                    System.out.println("  ─────────────────────────────────────────────");
                }
            }
        }
        SystemLog.log("ADMIN: SEARCHED ACCIDENTS BY DATE RANGE - " + startDate + " to " + endDate);
    }
    
    private void viewAllAccidents(AccidentService accidentService) {
        List<Accident> accidents = accidentService.getAllAccidents();
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("                     ACCIDENT REPORTS");
        System.out.println("═══════════════════════════════════════════════════════");
        
        if (accidents.isEmpty()) {
            System.out.println("               NO ACCIDENTS REPORTED");
        } else {
            for (Accident accident : accidents) {
                System.out.println(accident);
            }
            System.out.println("\n═══════════════════════════════════════════════════════");
            System.out.println("  Total Accidents: " + accidents.size());
            System.out.println("═══════════════════════════════════════════════════════");
        }
        SystemLog.log("ADMIN: VIEWED ALL ACCIDENT REPORTS");
    }
    
    private void viewStatistics(AccidentService accidentService) {
        List<Accident> accidents = accidentService.getAllAccidents();
        Map<String, Integer> severityCount = new HashMap<>();
        Map<String, Integer> districtCount = new HashMap<>();
        Map<String, Integer> dateCount = accidentService.getAccidentCountByDate();
        
        for (Accident acc : accidents) {
            String severity = acc.getSeverity().toUpperCase();
            severityCount.put(severity, severityCount.getOrDefault(severity, 0) + 1);
            
            String district = acc.getDistrict().toUpperCase();
            districtCount.put(district, districtCount.getOrDefault(district, 0) + 1);
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("                     ACCIDENT STATISTICS");
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("\n   BY SEVERITY:");
        System.out.println("      HIGH   : " + severityCount.getOrDefault("HIGH", 0));
        System.out.println("      MEDIUM : " + severityCount.getOrDefault("MEDIUM", 0));
        System.out.println("      LOW    : " + severityCount.getOrDefault("LOW", 0));
        
        System.out.println("\n   BY DISTRICT:");
        for (Map.Entry<String, Integer> entry : districtCount.entrySet()) {
            System.out.printf("     %-20s : %d\n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("\n  BY DATE:");
        if (dateCount.isEmpty()) {
            System.out.println("     No accidents reported");
        } else {
            for (Map.Entry<String, Integer> entry : dateCount.entrySet()) {
                System.out.printf("     %-12s : %d accidents\n", entry.getKey(), entry.getValue());
            }
        }
        
        System.out.println("\n  TOTAL ACCIDENTS: " + accidents.size());
        System.out.println("═══════════════════════════════════════════════════════");
        SystemLog.log("ADMIN: VIEWED STATISTICS");
    }
    
    private void manageHospitals() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║                  HOSPITAL MANAGEMENT               ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  1. View All Hospitals                               ║");
            System.out.println("║  2. View Hospitals by District                       ║");
            System.out.println("║  3. Search Hospital                                  ║");
            System.out.println("║  4. Add New Hospital                                 ║");
            System.out.println("║  5. Update Hospital                                  ║");
            System.out.println("║  6. Delete Hospital                                  ║");
            System.out.println("║  7. Back                                             ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print("Enter choice: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    HospitalData.viewAllHospitals();
                    break;
                case 2:
                    System.out.print("  Enter District: ");
                    String district = scanner.nextLine();
                    HospitalData.viewHospitalsByDistrict(district);
                    break;
                case 3:
                    System.out.print("  Enter search term: ");
                    String term = scanner.nextLine();
                    HospitalData.searchHospital(term);
                    break;
                case 4:
                    addHospital();
                    break;
                case 5:
                    updateHospital();
                    break;
                case 6:
                    deleteHospital();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("   Invalid choice!");
            }
        }
    }
    
    private void managePoliceStations() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║               POLICE STATION MANAGEMENT           ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  1. View All Police Stations                         ║");
            System.out.println("║  2. View Police Stations by District                 ║");
            System.out.println("║  3. Search Police Station                            ║");
            System.out.println("║  4. Add New Police Station                           ║");
            System.out.println("║  5. Update Police Station                            ║");
            System.out.println("║  6. Delete Police Station                            ║");
            System.out.println("║  7. Back                                             ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.print("Enter choice: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    PoliceData.viewAllPoliceStations();
                    break;
                case 2:
                    System.out.print("  Enter District: ");
                    String district = scanner.nextLine();
                    PoliceData.viewPoliceStationsByDistrict(district);
                    break;
                case 3:
                    System.out.print("  Enter search term: ");
                    String term = scanner.nextLine();
                    PoliceData.searchPoliceStation(term);
                    break;
                case 4:
                    addPoliceStation();
                    break;
                case 5:
                    updatePoliceStation();
                    break;
                case 6:
                    deletePoliceStation();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("  Invalid choice!");
            }
        }
    }
    
    private void addHospital() {
        System.out.println("\n===== ADD NEW HOSPITAL =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        System.out.print("  Enter Hospital Name: ");
        String hospitalName = scanner.nextLine();
        HospitalData.addHospital(district, town, hospitalName);
        SystemLog.log("ADMIN: ADDED HOSPITAL - " + hospitalName);
    }
    
    private void updateHospital() {
        System.out.println("\n===== UPDATE HOSPITAL =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        System.out.print("  Enter New Hospital Name: ");
        String newName = scanner.nextLine();
        HospitalData.updateHospital(district, town, newName);
        SystemLog.log("ADMIN: UPDATED HOSPITAL at " + district + "/" + town);
    }
    
    private void deleteHospital() {
        System.out.println("\n===== DELETE HOSPITAL =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        HospitalData.deleteHospital(district, town);
        SystemLog.log("ADMIN: DELETED HOSPITAL at " + district + "/" + town);
    }
    
    private void addPoliceStation() {
        System.out.println("\n===== ADD NEW POLICE STATION =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        System.out.print("  Enter Police Station Name: ");
        String stationName = scanner.nextLine();
        PoliceData.addPoliceStation(district, town, stationName);
        SystemLog.log("ADMIN: ADDED POLICE STATION - " + stationName);
    }
    
    private void updatePoliceStation() {
        System.out.println("\n===== UPDATE POLICE STATION =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        System.out.print("  Enter New Police Station Name: ");
        String newName = scanner.nextLine();
        PoliceData.updatePoliceStation(district, town, newName);
        SystemLog.log("ADMIN: UPDATED POLICE STATION at " + district + "/" + town);
    }
    
    private void deletePoliceStation() {
        System.out.println("\n===== DELETE POLICE STATION =====");
        System.out.print("  Enter District: ");
        String district = scanner.nextLine();
        System.out.print("  Enter Town: ");
        String town = scanner.nextLine();
        PoliceData.deletePoliceStation(district, town);
        SystemLog.log("ADMIN: DELETED POLICE STATION at " + district + "/" + town);
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