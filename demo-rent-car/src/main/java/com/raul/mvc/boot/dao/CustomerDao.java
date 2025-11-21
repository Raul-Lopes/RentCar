package com.raul.mvc.boot.dao;

import com.raul.mvc.boot.beans.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerDao {

    void save(Customer customer);

    void update(Customer customer);

    void delete(Long id);

    Customer findById(Long id);

    List<Customer> findAll();

    List<Customer> findByNome(String nome);

    List<Customer> findByCarId(Long id);

    List<Customer> findByDataNascimentoDataSaida(LocalDate entrada, LocalDate saida);

    List<Customer> findByDataNascimento(LocalDate entrada);

    List<Customer> findByDataSaida(LocalDate saida);
}
