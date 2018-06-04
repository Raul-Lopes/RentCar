package com.raul.mvc.boot.dao;

import java.util.List;

import com.raul.mvc.boot.beans.Car;

public interface CarDao {

    void save(Car car );

    void update(Car car);

    void delete(Long id);

    Car findById(Long id);
    
    Car findByNivel(String nivel);

    List<Car> findAll();
}
