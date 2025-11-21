package com.raul.mvc.boot.dao;

import com.raul.mvc.boot.beans.Brand;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDaoImpl extends AbstractDao<Brand, Long> implements BrandDao {

    //Repositorio do Spring JPA, a opcao de crud ja vem pronta do framework

}
