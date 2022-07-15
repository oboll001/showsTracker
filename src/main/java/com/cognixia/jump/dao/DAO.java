package com.cognixia.jump.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {
    // get one by id
    T findbyId(long id);
   

    

    // get all
    List<T> findAllbyId(long id);

    List<T> findAll();

    // add to db
    boolean create(T entity);

    boolean update();

    // boolean update(T entity);

    boolean deleteById(long id);
}
