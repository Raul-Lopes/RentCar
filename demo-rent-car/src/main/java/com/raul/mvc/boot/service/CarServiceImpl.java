package com.raul.mvc.boot.service;

import com.raul.mvc.boot.beans.Car;
import com.raul.mvc.boot.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao dao;

    @Override
    public void salvar(Car car) {
        dao.save(car);
    }

    @Override
    public void editar(Car car) {
        dao.update(car);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Car buscarPorId(Long id) {

        return dao.findById(id);
    }

    public Car buscarPorNivel(String nivel) {
        return dao.findByNivel(nivel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> buscarTodos() {

        return dao.findAll();
    }

    @Override
    public boolean carTemCustomers(Long id) {
        if (buscarPorId(id).getCustomers().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Car buscarPorNivel(Long nivel) {
        // TODO Auto-generated method stub
        return null;
    }
}
