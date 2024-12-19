package com.example.important_points;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MineradoraDeDados {

    public List<Integer> extrairPrimos(List<Integer> dadosBrutos){
        List<Integer> primos = new ArrayList<>();
        for (int numero : dadosBrutos) {
            if (ehPrimo(numero)) {
                primos.add(numero);
            }
        }
        return primos;
    }

    private boolean ehPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        for (int i = 5; i * i <= numero; i = i + 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}