package com.simple.api_web.model;

import com.simple.api_web.auth.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
public class CreditoRapido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricao;

    @CreationTimestamp
    private Instant dataDeCriacao;

    @OneToOne
    private GerenteDoCredito gerente;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public CreditoRapido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public GerenteDoCredito getGerente() {
        return gerente;
    }

    public void setGerente(GerenteDoCredito gerente) {
        this.gerente = gerente;
    }
}
