package service;

import model.Accident;
import java.util.*;
import java.io.*;

public class AccidentService {
    private Map<String, Accident> accidents;
    private Set<String> reportedVehicles;
    private static final String ACCIDENT_FILE = "accidents.txt";
    
    public AccidentService() {
        accidents = new LinkedHashMap<>();
        reportedVehicles = new HashSet<>();
    }
    
    public boolean isVehicleAlreadyReported(String vehicleNumber) {
        return reportedVehicles.contains(vehicleNumber.toUpperCase());
    }
    
    public Accident findAccidentByVehicle(String vehicleNumber) {
        for (Accident acc : accidents.values()) {
            if (acc.getVehicleNumber().equals(vehicleNumber.toUpperCase())) {
                return acc;
            }
        }
        return null;
    }
    
    public String generateAccidentId() {
        int maxId = 100;
        for (String id : accidents.keySet()) {
            if (id.startsWith("CASE")) {
                try {
                    int num = Integer.parseInt(id.substring(4));
                    if (num > maxId) maxId = num;
                } catch (NumberFormatException e) {}
            }
        }
        return String.format("CASE%03d", maxId + 1);
    }
    
    public void addAccident(Accident accident) {
        accidents.put(accident.getAccidentId(), accident);
        reportedVehicles.add(accident.getVehicleNumber());
        saveAccidentsToFile();
    }
    
    public Accident findAccidentById(String id) {
        return accidents.get(id);
    }
    
    public List<Accident> getAllAccidents() {
        return new ArrayList<>(accidents.values());
    }
    
    public List<Accident> getPendingAccidents() {
        List<Accident> pending = new ArrayList<>();
        for (Accident acc : accidents.values()) {
            if (acc.getPoliceAction().equals("Pending")) {
                pending.add(acc);
            }
        }
        return pending;
    }
    
    public List<Accident> getAcceptedAccidents() {
        List<Accident> accepted = new ArrayList<>();
        for (Accident acc : accidents.values()) {
            if (acc.getPoliceAction().equals("ACCEPTED") && !acc.isAmbulanceDispatched()) {
                accepted.add(acc);
            }
        }
        return accepted;
    }
    
    // ========== NEW: SEARCH ACCIDENTS BY DATE ==========
    public List<Accident> searchAccidentsByDate(String date) {
        List<Accident> result = new ArrayList<>();
        for (Accident acc : accidents.values()) {
            if (acc.getDateOnly().equals(date)) {
                result.add(acc);
            }
        }
        return result;
    }
    
    // ========== NEW: SEARCH ACCIDENTS BY DATE RANGE ==========
    public List<Accident> searchAccidentsByDateRange(String startDate, String endDate) {
        List<Accident> result = new ArrayList<>();
        for (Accident acc : accidents.values()) {
            String accDate = acc.getDateOnly();
            if (accDate.compareTo(startDate) >= 0 && accDate.compareTo(endDate) <= 0) {
                result.add(acc);
            }
        }
        return result;
    }
    
    // ========== NEW: GET ALL UNIQUE DATES ==========
    public Set<String> getAllAccidentDates() {
        Set<String> dates = new TreeSet<>();
        for (Accident acc : accidents.values()) {
            dates.add(acc.getDateOnly());
        }
        return dates;
    }
    
    // ========== NEW: COUNT ACCIDENTS BY DATE ==========
    public Map<String, Integer> getAccidentCountByDate() {
        Map<String, Integer> dateCount = new TreeMap<>();
        for (Accident acc : accidents.values()) {
            String date = acc.getDateOnly();
            dateCount.put(date, dateCount.getOrDefault(date, 0) + 1);
        }
        return dateCount;
    }
    
    public int getTotalAccidents() { return accidents.size(); }
    public int getAcceptedCount() { return getAcceptedAccidents().size(); }
    public int getPendingCount() { return getPendingAccidents().size(); }
    
    public void saveAllData() { saveAccidentsToFile(); }
    
    public void loadAllData() { loadAccidentsFromFile(); }
    
    public void saveAccidentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ACCIDENT_FILE))) {
            for (Accident acc : accidents.values()) {
                writer.println(acc.toFileString());
            }
            System.out.println(" Accidents saved to file");
        } catch (IOException e) {
            System.out.println(" Error saving accidents: " + e.getMessage());
        }
    }
    
    private void loadAccidentsFromFile() {
        File file = new File(ACCIDENT_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Accident acc = Accident.fromString(line);
                if (acc != null) {
                    accidents.put(acc.getAccidentId(), acc);
                    reportedVehicles.add(acc.getVehicleNumber());
                }
            }
            System.out.println(" Loaded " + accidents.size() + " accidents");
        } catch (IOException e) {
            System.out.println(" Error loading accidents: " + e.getMessage());
        }
    }
    
    public void clearAllData() {
        accidents.clear();
        reportedVehicles.clear();
        File file = new File(ACCIDENT_FILE);
        if (file.exists()) file.delete();
    }
}