package com.example.important_points;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SeguroBuilder {

    private Seguro seguro = new Seguro();

    public SeguroBuilder withTipo(String tipo){
        seguro.setTipo(tipo);
        return this;
    }

    public SeguroBuilder withValorMensal(BigDecimal valorMensal){
        seguro.setValorMensal(valorMensal);
        return this;
    }
    public SeguroBuilder withDataDeInicioDaVigencia(){
        seguro.setDataInicioVigencia(LocalDate.now());
        return this;
    }

    public Seguro build(){
        return seguro;
    }

}
