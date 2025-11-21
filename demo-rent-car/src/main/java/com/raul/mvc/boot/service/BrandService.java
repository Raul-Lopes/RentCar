package com.raul.mvc.boot.service;

import com.raul.mvc.boot.beans.Brand;

import java.util.List;

public interface BrandService {

    void salvar(Brand brand);

    void editar(Brand brand);

    void excluir(Long id);

    Brand buscarPorId(Long id);

    List<Brand> buscarTodos();

    boolean brandTemCars(Long id);
}
