package com.example.important_points;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class Mensagem {

    private String assunto;
    private String conteudo;
    private LocalDateTime instante;

    public Mensagem() { }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "assunto='" + assunto + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", instante=" + instante +
                '}';
    }
}