package com.simple.api_web.service;

import com.simple.api_web.model.CreditoDto;
import com.simple.api_web.model.CreditoRapido;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditoRapidoService {
    public CreditoRapido post(CreditoDto creditoDto) {
        return null;
    }

    public Optional<CreditoRapido> creditoPorTomador(Long tomador) {
        return Optional.empty();
    }

    public void aprovarCredito(Long tomador) {
    }

    public void cancelarCredito(Long tomador) {
    }
}
