package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoPubSub {

    @Autowired
    MensagemBuilder mensagemBuilder;

    public void publicarMensagem(String assunto, String conteudo) {

        System.out.println("INICIO DO SERVICO DE PUBSUB");

        Mensagem mensagem = mensagemBuilder.comAssunto(assunto).comConteudo(conteudo).comInstante().build();

        System.out.println("A seguinte mensagem foi publicada: " + mensagem);

    };
}