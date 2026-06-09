package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.db.DataSource;
import com.model.Patient;

public class Main {
    public static void main(String[] args) {
        
    }


    public static List<Patient> fetchData() throws SQLException {
        String SQL_QUERY = "SELECT * FROM patients";
        List<Patient> patients = null;
        try(Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_QUERY); ResultSet rs = pst.executeQuery();){
            patients = new ArrayList<>();
            Patient patient;
            while( rs.next()){
                patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("fname"));
                patient.setLastName(rs.getString("lname"));
                patient.setDob(rs.getObject("dob", LocalDate.class));
                patient.setSex(rs.getString("sex"));
                patient.setHeightCm(rs.getInt("height_cm"));
                patient.setWeightKg(rs.getInt("weight_kg"));
                patient.setBloodType(rs.getString("blood_type"));
                patients.add(patient);
            }
        }
        return patients;
    }
}