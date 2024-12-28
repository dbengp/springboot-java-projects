package com.simple.api_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class TomadorDoCredito {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String email;

    @NotEmpty
    private String endereco;

    @CPF
	@NotNull
    private String cpf;

    public TomadorDoCredito() {
    }

    public TomadorDoCredito(String nome, String email, String endereco, String cpf) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public @NotEmpty String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotEmpty String endereco) {
        this.endereco = endereco;
    }

    public @CPF @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF @NotNull String cpf) {
        this.cpf = cpf;
    }
}