package com.model;

import java.time.LocalDateTime;

public class Appointment {
    private Integer appId;
    private Integer patientId;
    private Integer doctorId; // nullable
    private LocalDateTime appointmentDate;
    private String reason;

    // No-arg constructor
    public Appointment() {
    }

    // All-args constructor
    public Appointment(Integer appId, Integer patientId, Integer doctorId, LocalDateTime appointmentDate, String reason) {
        this.appId = appId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
    }

    // Getters
    public Integer getAppId() { return appId; }
    public Integer getPatientId() { return patientId; }
    public Integer getDoctorId() { return doctorId; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public String getReason() { return reason; }

    // Setters
    public void setAppId(Integer appId) { this.appId = appId; }
    public void setPatientId(Integer patientId) { this.patientId = patientId; }
    public void setDoctorId(Integer doctorId) { this.doctorId = doctorId; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }
    public void setReason(String reason) { this.reason = reason; }

    // toString
    @Override
    public String toString() {
        return "Appointment{" +
                "appId=" + appId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDate=" + appointmentDate +
                ", reason='" + reason + '\'' +
                '}';
    }

}
