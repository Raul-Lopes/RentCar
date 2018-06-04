package com.raul.mvc.boot.service;

import java.util.List;

import com.raul.mvc.boot.beans.Car;

public interface CarService {

	void salvar(Car car);
	
	void editar(Car car);
	
	void excluir(Long id);
	
	Car buscarPorId(Long id);
	
	Car buscarPorNivel(Long nivel);
	
	List<Car> buscarTodos();
	
	boolean carTemCustomers(Long id);
}
