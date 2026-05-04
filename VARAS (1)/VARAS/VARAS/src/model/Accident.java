package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Accident implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String accidentId;
    private String vehicleNumber;
    private String reporterName;
    private String district;
    private String town;
    private String severity;
    private String policeStation;
    private String hospital;
    private String status;
    private String policeAction;
    private boolean ambulanceDispatched;
    private String ambulanceStatus;
    private Date reportDate;
    
    public Accident(String accidentId, String vehicleNumber, String reporterName, String district, String town, 
                    String severity, String policeStation, String hospital) {
        this.accidentId = accidentId;
        this.vehicleNumber = vehicleNumber.toUpperCase();
        this.reporterName = reporterName;
        this.district = district.toLowerCase();
        this.town = town.toLowerCase();
        this.severity = severity.toLowerCase();
        this.policeStation = policeStation;
        this.hospital = hospital;
        this.status = "Reported";
        this.policeAction = "Pending";
        this.ambulanceDispatched = false;
        this.ambulanceStatus = "Not Dispatched";
        this.reportDate = new Date();
    }
    
    // Getters
    public String getAccidentId() { return accidentId; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getReporterName() { return reporterName; }
    public String getDistrict() { return district; }
    public String getTown() { return town; }
    public String getSeverity() { return severity; }
    public String getPoliceStation() { return policeStation; }
    public String getHospital() { return hospital; }
    public String getStatus() { return status; }
    public String getPoliceAction() { return policeAction; }
    public boolean isAmbulanceDispatched() { return ambulanceDispatched; }
    public String getAmbulanceStatus() { return ambulanceStatus; }
    public Date getReportDate() { return reportDate; }
    
    public String getLocation() { return town + ", " + district; }
    
    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(reportDate);
    }
    
    public String getDateOnly() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(reportDate);
    }
    
    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setPoliceAction(String policeAction) { this.policeAction = policeAction; }
    public void setAmbulanceDispatched(boolean dispatched) { this.ambulanceDispatched = dispatched; }
    public void setAmbulanceStatus(String status) { this.ambulanceStatus = status; }
    
    public String toFileString() {
        return accidentId + "|" + vehicleNumber + "|" + reporterName + "|" + district + "|" + town + "|" + 
               severity + "|" + policeStation + "|" + hospital + "|" + status + "|" + policeAction + "|" + 
               ambulanceDispatched + "|" + ambulanceStatus + "|" + reportDate.getTime();
    }
    
    public static Accident fromString(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length >= 8) {
                Accident acc = new Accident(parts[0], parts[1], parts[2], parts[3], parts[4], 
                                             parts[5], parts[6], parts[7]);
                if (parts.length > 8) acc.setStatus(parts[8]);
                if (parts.length > 9) acc.setPoliceAction(parts[9]);
                if (parts.length > 10) acc.setAmbulanceDispatched(Boolean.parseBoolean(parts[10]));
                if (parts.length > 11) acc.setAmbulanceStatus(parts[11]);
                if (parts.length > 12) acc.reportDate = new Date(Long.parseLong(parts[12]));
                return acc;
            }
        } catch (Exception e) {
            System.out.println("Error parsing accident: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\n═══════════════════════════════════════════════════════\n" +
               "              ACCIDENT REPORT\n" +
               "═══════════════════════════════════════════════════════\n" +
               "  Case ID      : " + accidentId + "\n" +
               "  Date & Time  : " + getDateTime() + "\n" +
               "  Reporter     : " + reporterName + "\n" +
               "  Vehicle      : " + vehicleNumber + "\n" +
               "  Location     : " + getLocation() + "\n" +
               "  Severity     : " + severity.toUpperCase() + "\n" +
               "  Status       : " + status + "\n" +
               "  Police Action: " + policeAction + "\n" +
               "  Police       : " + policeStation + "\n" +
               "  Hospital     : " + hospital + "\n" +
               "  Ambulance    : " + ambulanceStatus + "\n" +
               "═══════════════════════════════════════════════════════";
    }
}