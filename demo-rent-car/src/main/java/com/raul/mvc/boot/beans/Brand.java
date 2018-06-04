package com.raul.mvc.boot.beans;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "BRAND")
public class Brand extends AbstractEntity<Long> {

	@NotBlank(message = "Enter a name")
	@Size(min = 3, max = 60, message = "The brand name must be between {min} and {max} characters.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "brand")
	private List<Car> cars;

	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
