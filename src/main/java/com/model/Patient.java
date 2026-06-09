package com.model;

import java.time.LocalDate;

public class Patient {
    private Integer patientId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String sex;
    private Integer heightCm;
    private Integer weightKg;
    private String bloodType;

    // No-arg constructor for frameworks
    public Patient() {
    }

    // All-args constructor
    public Patient(Integer patientId, String firstName, String lastName, LocalDate dob, String sex, Integer heightCm, Integer weightKg, String bloodType) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.bloodType = bloodType;
    }

    // Getters
    public Integer getPatientId() { return patientId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getDob() { return dob; }
    public String getSex() { return sex; }
    public Integer getHeightCm() { return heightCm; }
    public Integer getWeightKg() { return weightKg; }
    public String getBloodType() { return bloodType; }

    // Setters
    public void setPatientId(Integer patientId) { this.patientId = patientId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setSex(String sex) { this.sex = sex; }
    public void setHeightCm(Integer heightCm) { this.heightCm = heightCm; }
    public void setWeightKg(Integer weightKg) { this.weightKg = weightKg; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    // toString
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", sex='" + sex + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

}

