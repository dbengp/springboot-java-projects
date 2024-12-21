package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObtemClientes {

	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> obter(){
		
		ClienteFactory factory = new ClienteFactory();
	
		List<Cliente> clientes = new ArrayList<>();
		
		List<String> nomes = List.of("Ana Anibal","João Batista","Maria do Carmo","José Alencar","Pedro Cardoso","Roberto Carlos","Nilson Chaves","Eva Mendes","Abel Figueredo", "Bob Marley");
		for (int i = 0; i < 10; i++) {
			Cliente cliente = factory.criarCliente(" " + nomes.get(i), "123.456.789-0" + i, LocalDate.now());
			clientes.add(cliente);
		}

		salvar(clientes);
		
		return clientes;
	}

	public void salvar(List<Cliente> clientes){
		repository.saveAll(clientes);
	}

}
