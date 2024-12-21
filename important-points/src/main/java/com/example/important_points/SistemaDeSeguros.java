package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SistemaDeSeguros implements CommandLineRunner {

    @Autowired
    SeguroRepository repository;

    @Autowired
    SegurosDisponiveis segurosDisponiveis;

    @Autowired
    ObtemClientes clientesAtivos;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=== APLICACAO INICIADA || SISTEMAS DE SEGUROS BANCO INTERPLANETÁRIO ===");

        List<Cliente> clientes = clientesAtivos.obter();

        List<Seguro> seguros = segurosDisponiveis.carrega();

        seguros.get(0).setCliente(clientes.get(9));
        seguros.get(1).setCliente(clientes.get(8));
        seguros.get(2).setCliente(clientes.get(7));
        seguros.get(3).setCliente(clientes.get(6));
        seguros.get(4).setCliente(clientes.get(9));
        seguros.get(5).setCliente(clientes.get(8));
        seguros.get(6).setCliente(clientes.get(7));
        seguros.get(7).setCliente(clientes.get(6));
        seguros.get(8).setCliente(clientes.get(5));
        seguros.get(9).setCliente(clientes.get(4));

        repository.saveAll(seguros);

        List<Seguro> resultadoDaConsulta = repository.findAll();

        for (Seguro seguro : resultadoDaConsulta){
            System.out.println(seguro);
        }
        System.out.println("=== FIM DA APLICACAO ===");
    }
}
