package com.raul.mvc.boot.dao;

import java.util.List;

import com.raul.mvc.boot.beans.Brand;

public interface BrandDao {

    void save(Brand brand);

    void update(Brand brand);

    void delete(Long id);

    Brand findById(Long id);

    List<Brand> findAll();
}
