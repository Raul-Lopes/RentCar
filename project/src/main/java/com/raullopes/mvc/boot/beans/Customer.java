package com.raullopes.mvc.boot.beans;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends AbstractEntity<Long> {

    @NotBlank
    @Size(max = 255, min = 3)
    @Column(nullable = false, unique = true)
    private String nome;

    @NotNull
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal aluguel;

    @NotNull
    @PastOrPresent(message = "{PastOrPresent.customer.dataNascimento}")
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "data_saida", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fk_address")
    private Address address;

    @NotNull(message = "{NotNull.customer.car}")
    @ManyToOne
    @JoinColumn(name = "id_fk_car")
    private Car car;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getAluguel() {
        return aluguel;
    }

    public void setAluguel(BigDecimal aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
