package com.raul.mvc.boot.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARS")
public class Car extends AbstractEntity<Long> {

	@NotBlank(message = "The car's name is required.")
	@Size(max = 60, message = "The car name must contain a maximum of 60 characters.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@Column(name = "model", nullable = false, length = 30) 
	private String model;
	
	@NotNull(message = "Select the brand relative to the car.")
	@ManyToOne
	@JoinColumn(name = "id_fk_brand")
	private Brand brand;
	 
	@OneToMany(mappedBy = "car")
	private List<Customer> customers;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
 
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
