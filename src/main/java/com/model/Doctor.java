package com.model;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;

    // No-arg constructor
    public Doctor() {
    }

    // All-args constructor
    public Doctor(int doctorId, String firstName, String lastName, String specialty) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    // Getters
    public int getDoctorId() { return doctorId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSpecialty() { return specialty; }

    // Setters
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    // toString
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

}
