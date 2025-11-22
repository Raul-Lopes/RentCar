package com.raullopes.mvc.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.raullopes.mvc.boot.beans.Customer;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Customer.class.equals(clazz);
	}
	  
	@Override
	public void validate(Object object, Errors errors) {
		
		Customer f = (Customer) object;
		
		LocalDate entrada = f.getDataNascimento();
		
		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataNascimento.customer.dataSaida");
			}
		}
	}

}
