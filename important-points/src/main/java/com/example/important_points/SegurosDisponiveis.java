package com.example.important_points;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SegurosDisponiveis {

    public List<Seguro> carrega() {

        List<Seguro> seguros = new ArrayList<>();

        List<String> tiposDeSeguros = List.of("Seguro de Vida","Seguro de Carro");
        for (int i = 0; i < 10; i++) {
            int j = i % 2;
            SeguroBuilder builder = new SeguroBuilder();

            seguros.add(
                    builder.withTipo(tiposDeSeguros.get(j))
                            .withValorMensal(BigDecimal.valueOf(100.99 + i))
                            .withDataDeInicioDaVigencia()
                            .build()
            );
        }
        return seguros;
    }

}