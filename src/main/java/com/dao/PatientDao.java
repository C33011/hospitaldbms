package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.model.Patient;

public class PatientDao implements Dao<Patient> {

    private List<Patient> patients = new ArrayList<>();

    public PatientDao() {
        
    }

    @Override
    public Optional<Patient> get(int id) {
        return Optional.ofNullable(patients.get(id));
    }

    @Override
    public List<Patient> getAll(){
        return new ArrayList<>(patients);
    }

    @Override
    public void add(Patient p){
        patients.add(p);
    }

    //This is risky since it just reads the list of input params and doesnt handle missing params well.
    //TODO: Fix this ^

    @Override
    public void update(Patient p, String[] params){
        p.setFirstName(Objects.requireNonNull(params[0], "First name cannot be null"));
        p.setLastName(Objects.requireNonNull(params[1], "Last name cannot be null"));
        p.setDob(LocalDate.parse(params[2]));
        p.setSex(params[3]);
        p.setHeightCm(Integer.parseInt(params[4]));
        p.setWeightKg(Integer.parseInt(params[5]));
        p.setBloodType(params[6]);
    }
    
    @Override
    public void delete(Patient p){
        patients.remove(p);
    }



}
