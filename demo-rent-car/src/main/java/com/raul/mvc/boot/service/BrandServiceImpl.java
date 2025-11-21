package com.raul.mvc.boot.service;

import com.raul.mvc.boot.beans.Brand;
import com.raul.mvc.boot.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao dao;

    @Transactional(readOnly = false)
    @Override
    public void salvar(Brand brand) {
        dao.save(brand);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Brand brand) {
        dao.update(brand);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Brand buscarPorId(Long id) {

        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Brand> buscarTodos() {

        return dao.findAll();
    }

    @Override
    public boolean brandTemCars(Long id) {
        if (buscarPorId(id).getCars().isEmpty()) {
            return false;
        }
        return true;
    }

}
