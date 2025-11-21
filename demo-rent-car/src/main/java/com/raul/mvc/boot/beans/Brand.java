package com.raul.mvc.boot.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

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
