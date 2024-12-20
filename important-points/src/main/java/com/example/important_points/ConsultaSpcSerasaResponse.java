package com.example.important_points;

public class ConsultaSpcSerasaResponse {
    
	private String cep;
    private String score;
    private String nome;
	private String restricao;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    @Override
    public String toString() {
        return "'cep' = '" + cep + '\'' +
                ", 'score' = '" + score + '\'' +
                ", 'nome' = '" + nome + '\'' +
                ", 'restricao' = '" + restricao + '\'' + '.';
    }

}