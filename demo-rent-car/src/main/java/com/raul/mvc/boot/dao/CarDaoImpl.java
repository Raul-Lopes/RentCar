package com.raul.mvc.boot.dao;

import org.springframework.stereotype.Repository;

import com.raul.mvc.boot.beans.Car;

@Repository
public class CarDaoImpl extends AbstractDao<Car, Long> implements CarDao {

	@Override
	public Car findByNivel(String nivel) {
		// TODO Auto-generated method stub
		return null;
	}

}
