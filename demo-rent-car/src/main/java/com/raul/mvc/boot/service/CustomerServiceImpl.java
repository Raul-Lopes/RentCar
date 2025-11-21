package com.raul.mvc.boot.service;

import com.raul.mvc.boot.beans.Customer;
import com.raul.mvc.boot.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Customer customer) {
		dao.save(customer);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Customer customer) {
		dao.update(customer);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Customer buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Customer> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Customer> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	public List<Customer> buscarPorCar(Long id) {
		
		return dao.findByCarId(id);
	}

	@Override
    public List<Customer> buscarPorDatas(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return dao.findByDataNascimentoDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return dao.findByDataNascimento(entrada);
        } else if (saida != null) {        	
	        return dao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }
}
