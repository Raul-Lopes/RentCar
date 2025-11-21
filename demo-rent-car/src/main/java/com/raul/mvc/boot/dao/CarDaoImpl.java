package com.raul.mvc.boot.dao;

import com.raul.mvc.boot.beans.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends AbstractDao<Car, Long> implements CarDao {

    @Override
    public Car findByNivel(String nivel) {
        // TODO Auto-generated method stub
        return null;
    }

}
