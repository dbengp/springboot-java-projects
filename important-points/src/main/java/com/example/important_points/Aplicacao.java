package com.example.important_points;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aplicacao")
public class Aplicacao {

	private String versao;
	private String pessoalTecnico;
	private String contato;

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public void setPessoalTecnico(String pessoalTecnico) {
		this.pessoalTecnico = pessoalTecnico;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getVersao() {
		return versao;
	}

	public String getPessoalTecnico() {
		return pessoalTecnico;
	}

	public String getContato() {
		return contato;
	}
}