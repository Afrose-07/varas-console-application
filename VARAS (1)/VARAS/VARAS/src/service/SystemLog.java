package service;

import java.util.*;
import java.io.*;

public class SystemLog {
    private static List<String> logs = new ArrayList<>();
    private static final String LOG_FILE = "system_log.txt";
    
    public static void log(String message) {
        String logEntry = "[" + new Date() + "] 🖥️ SYSTEM: " + message;
        logs.add(logEntry);
        System.out.println(" " + logEntry);
        saveLogs();
    }
    
    public static void saveLogs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            for (String log : logs) {
                writer.println(log);
            }
        } catch (IOException e) {}
    }
    
    public static void loadLogs() {
        File file = new File(LOG_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logs.add(line);
            }
        } catch (IOException e) {}
    }
    
    public static void viewSystemLog() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("                    🖥️ SYSTEM LOG");
        System.out.println("═".repeat(70));
        
        if (logs.isEmpty()) {
            System.out.println("No system logs yet.");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
        System.out.println("═".repeat(70));
    }
    
    public static void clearLogs() {
        logs.clear();
        File file = new File(LOG_FILE);
        if (file.exists()) file.delete();
    }
}