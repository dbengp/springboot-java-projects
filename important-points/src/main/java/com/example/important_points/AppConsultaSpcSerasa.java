package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppConsultaSpcSerasa implements CommandLineRunner {

	@Autowired
	ServicoPubSub servicoPubSub;

	@Autowired
	ConversorJson conversor;
	
	@Autowired
	Aplicacao aplicacao;
	
	@Override
	public void run (String... args) throws Exception {

		System.out.println("=== INICIO DA API DE CONSULTA NO SPC-SERASA ===");
		System.out.println("=== VERSAO: " + aplicacao.getVersao() + "|| PESSOAL TÉCNICO: " + aplicacao.getPessoalTecnico() + " || CONTATO: " + aplicacao.getContato()+ "===");
	
		String json = "{\"score\": \"900\", \"nome\": \"Seu Madruga\",\"dataNascimento\": \"1890-01-01\",\"cep\": \"01001-000\",\"restricao\": \"nenhuma restrição encontrada\"}";

		ConsultaSpcSerasaResponse response = conversor.converter(json);

		System.out.println("Dados da Consulta: " + response);

		String assunto = response.getRestricao();
		String conteudo = "O Senhor " + response.getNome() + " tem score de " + response.getScore();

		servicoPubSub.publicarMensagem(assunto, conteudo);
	}

}