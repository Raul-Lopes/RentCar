package com.raul.mvc.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.raul.mvc.boot.beans.Brand;
import com.raul.mvc.boot.service.BrandService;

@Component
public class StringToBrandConverter implements Converter<String, Brand> {
	
	@Autowired
	private BrandService service;

	@Override
	public Brand convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
