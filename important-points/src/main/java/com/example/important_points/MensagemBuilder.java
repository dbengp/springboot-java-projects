package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MensagemBuilder {

    @Autowired
    private Mensagem mensagem;

    public MensagemBuilder comAssunto(String assunto) {
        mensagem.setAssunto(assunto);
        return this;
    }

    public MensagemBuilder comConteudo(String conteudo) {
        mensagem.setConteudo(conteudo);
        return this;
    }

    public MensagemBuilder comInstante() {
        mensagem.setInstante(LocalDateTime.now());
        return this;
    }

    public Mensagem build() {
        return mensagem;
    }
}