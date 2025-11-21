package com.raul.mvc.boot.service;

import com.raul.mvc.boot.beans.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    void salvar(Customer customer);

    void editar(Customer customer);

    void excluir(Long id);

    Customer buscarPorId(Long id);

    List<Customer> buscarTodos();

    List<Customer> buscarPorNome(String nome);

    List<Customer> buscarPorCar(Long id);

    List<Customer> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
