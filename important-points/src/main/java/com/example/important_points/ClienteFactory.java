package com.example.important_points;

import java.time.LocalDate;

public class ClienteFactory {
    public Cliente criarCliente(String nome, String cpf, LocalDate dataNascimento) {
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(dataNascimento);
        
		return cliente;
    }
}