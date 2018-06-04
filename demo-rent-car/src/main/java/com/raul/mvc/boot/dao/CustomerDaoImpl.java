package com.raul.mvc.boot.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.raul.mvc.boot.beans.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDao<Customer, Long> implements CustomerDao {

	public List<Customer> findByNome(String nome) {
		
		return createQuery("select f from Customer f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Customer> findByCarId(Long id) {
		 
		return createQuery("select f from Customer f where f.car.id = ?1", id);
	}

	@Override
	public List<Customer> findByDataNascimentoDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Customer f ")
				.append("where f.dataNascimento >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataNascimento asc")
				.toString();
		 
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Customer> findByDataNascimento(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Customer f ")
				.append("where f.dataNascimento = ?1 ")
				.append("order by f.dataNascimento asc")
				.toString();
		
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Customer> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Customer f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataNascimento asc")
				.toString();
		
		return createQuery(jpql, saida);
	}	
	
}
