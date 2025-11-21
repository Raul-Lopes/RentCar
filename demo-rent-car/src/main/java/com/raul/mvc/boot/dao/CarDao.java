package com.raul.mvc.boot.dao;

import com.raul.mvc.boot.beans.Car;

import java.util.List;

public interface CarDao {

    void save(Car car);

    void update(Car car);

    void delete(Long id);

    Car findById(Long id);

    Car findByNivel(String nivel);

    List<Car> findAll();
}
