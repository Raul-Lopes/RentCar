package com.raul.mvc.boot.dao;

import org.springframework.stereotype.Repository;

import com.raul.mvc.boot.beans.Brand;

@Repository
public class BrandDaoImpl extends AbstractDao<Brand, Long> implements BrandDao {

	//Repositorio do Spring JPA, a opcao de crud ja vem pronta do framework
	
}
