package com.model;

import java.util.Date;

public class Patient {
    private int patient_id;
    private String fname;
    private String lname;
    private Date dob;
    private char sex;
    private int height_cm;
    private int weight_kg;
    private String blood_type;

    //Constructor
    public Patient(int patient_id, String fname, String lname, Date dob, char sex, int height_cm, int weight_kg, String blood_type){
        this.patient_id = patient_id;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.sex = sex;
        this.height_cm = height_cm;
        this.weight_kg = weight_kg;
        this.blood_type = blood_type;
    }

    //Getters
    

}
