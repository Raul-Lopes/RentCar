package com.raullopes.mvc.boot.dao;

import com.raullopes.mvc.boot.beans.Brand;

import java.util.List;

public interface BrandDao {

    void save(Brand brand);

    void update(Brand brand);

    void delete(Long id);

    Brand findById(Long id);

    List<Brand> findAll();
}
