package com.raul.mvc.boot.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

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
