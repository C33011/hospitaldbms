package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.model.Doctor;

public class DoctorDao implements Dao<Doctor> {

    private List<Doctor> doctors = new ArrayList<>();

    public DoctorDao() {

    }

    @Override
    public Optional<Doctor> get(int id){
        return Optional.ofNullable(doctors.get(id));
    }

    @Override
    public List<Doctor> getAll(){
        return new ArrayList<>(doctors);
    }
    
    @Override
    public void add(Doctor d){
        doctors.add(d);
    }

    @Override
    public void update(Doctor d, String[] params){
        d.setFirstName(Objects.requireNonNull(params[0],"First name cannot be null"));
        d.setLastName(Objects.requireNonNull(params[1], "Last name cannot be null"));
        d.setSpecialty(params[2]);
    }

    @Override
    public void delete(Doctor d){
        doctors.remove(d);
    }
}
