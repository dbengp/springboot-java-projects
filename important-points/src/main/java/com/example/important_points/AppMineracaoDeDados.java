package com.example.important_points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppMineracaoDeDados implements CommandLineRunner {

    @Autowired
    private MineradoraDeDados mineradoraDeDados;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("INICÍIO DA APLICAÇÃO DE MINERAÇÃO DE DADOS");
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                          14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
        List<Integer> primos = mineradoraDeDados.extrairPrimos(numeros);
        System.out.println("Os números primos são: " + primos);
    }
}
