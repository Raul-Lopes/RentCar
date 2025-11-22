package com.raullopes.mvc.boot.service;

import com.raullopes.mvc.boot.beans.Car;

import java.util.List;

public interface CarService {

    void salvar(Car car);

    void editar(Car car);

    void excluir(Long id);

    Car buscarPorId(Long id);

    Car buscarPorNivel(Long nivel);

    List<Car> buscarTodos();

    boolean carTemCustomers(Long id);
}
