package com.simple.api_web.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GerenteDoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGerente;

    private String agencia;
    private String nome;
    private String token;

    @OneToMany
    private List<CreditoRapido> creditos;

    public GerenteDoCredito() { }

    public GerenteDoCredito(String token, String agencia, String nome) {
        this.token = token;
        this.agencia = agencia;
        this.nome = nome;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setToken() {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
