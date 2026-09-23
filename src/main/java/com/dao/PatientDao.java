package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.db.DataSource;
import com.model.Patient;

public class PatientDao implements Dao<Patient> {

    private List<Patient> patients = new ArrayList<>();

    public PatientDao() {
        
    }

    @Override
    public Optional<Patient> get(int id) {
        String sql = """
                SELECT patient_id, fname, lname, dob, sex, height_cm, weight_kg, blood_type
                FROM patients
                WHERE patient_id = ?
                """;

        try(Connection connection = DataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            try(ResultSet results = statement.executeQuery()){
                if(results.next()){
                    Patient patient = new Patient();
                    patient.setPatientId(results.getInt("patient_id"));
                    patient.setFirstName(results.getString("fname"));
                    patient.setLastName(results.getString("lname"));
                    patient.setDob(results.getObject("dob", LocalDate.class));
                    patient.setSex(results.getString("sex"));
                    patient.setHeightCm(results.getInt("height_cm"));
                    patient.setWeightKg(results.getInt("weight_kg"));
                    patient.setBloodType(results.getString("blood_type"));
                
                    return Optional.of(patient);
                }
            }
        } catch(SQLException exception){
            throw new RuntimeException("Could not find patient", exception);
        }
        return Optional.empty();
    }
    

    @Override
    public List<Patient> getAll(){
        return new ArrayList<>(patients);
    }

    @Override
    public void add(Patient p){
        String sql = """
                INSERT INTO patients
                (fname, lname, dob, sex, height_cm, weight_kg, blood_type)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                RETURNING patient_id
                """;

        try(Connection connection = DataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, p.getFirstName());
            statement.setString(2, p.getLastName());
            if(p.getDob() == null){
                statement.setNull(3, java.sql.Types.DATE);
            } else {
                statement.setDate(3, Date.valueOf(p.getDob()));
            }
            statement.setString(4, p.getSex());
            statement.setInt(5, p.getHeightCm());
            statement.setInt(6, p.getWeightKg());
            statement.setString(7, p.getBloodType());


            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    p.setPatientId(rs.getInt("patient_id"));
                }
            }   
            
        } catch(SQLException exception){
            throw new RuntimeException("Could not add patient", exception);
        }
    }

    //This is risky since it just reads the list of input params and doesnt handle missing params well.
    //TODO: Fix this(?)
    //This is probably bad and not industry standard AT ALLLLL but since the only way of calling it will be through a structured system, the non-filled parts will be auto-nulled!

    @Override
    public void update(Patient p, int id){

        String sql = """
                UPDATE patients
                SET fname = ?, lname = ?, dob = ?, sex = ?, height = ?, weight = ?, blood_type = ?
                WHERE patient_id = ?
                """;
        
        try(Connection connection = DataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            Patient pr = get(id).get();
            statement.setString(1, p.getFirstName());
            statement.setString(2,p.getLastName());
            if(p.getDob() == null){
                statement.setNull(3, java.sql.Types.DATE);
            } else {
                statement.setDate(3, Date.valueOf(p.getDob()));
            }
            statement.setString(4, p.getSex());
            statement.setInt(5, p.getHeightCm());
            statement.setInt(6, p.getWeightKg());
            statement.setString(7, p.getBloodType());
            statement.setInt(8, id);

            try (int rs = statement.executeUpdate()) {
                if (rs.next()) {
                    if(rs.getInt() > 0){
                        throw new RuntimeException("Unsuccessfully updated row");
                    }
                }
            }   

        }
        catch(SQLException exception){

        }
    }
    
    @Override
    public void delete(int id){
        
    }



}
