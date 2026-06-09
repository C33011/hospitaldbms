package com.dao;

import java.util.List;
import java.util.Optional;

//This is the DAO template interface. Explaining how I understand it, this serves as an abstract interface for all other DAO files to use for method definition
//This helps keep the domain model decoupled from the persistance layer!
public interface Dao<T> {
    
    //R in CRUD
    Optional<T> get(int id);

    List<T> getAll();

    //C in CRUD
    void add(T t);

    //U in CRUD
    void update(T t, String[] params);

    //D in CRUD
    void delete(T t);

    //Yay what a CRUDdy file :D 
}
