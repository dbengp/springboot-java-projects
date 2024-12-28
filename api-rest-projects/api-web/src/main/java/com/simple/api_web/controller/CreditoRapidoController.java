package com.simple.api_web.controller;

import com.simple.api_web.auth.SecurityConfig;
import com.simple.api_web.model.CreditoDto;
import com.simple.api_web.model.CreditoRapido;
import com.simple.api_web.service.CreditoRapidoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path ="/credito-rapido")
@Tag(name = "credito-rapido")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class CreditoRapidoController {

    @Autowired
    private CreditoRapidoService creditoRapidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditoRapido propostaDeCredito(@RequestBody CreditoDto creditoDto) {
        CreditoRapido creditoRapido = creditoRapidoService.post(creditoDto);
        return creditoRapido;
    }

    @GetMapping("/{tomador}")
    public ResponseEntity<CreditoRapido> creditoPorTomador(@PathVariable Long tomador) {
        Optional<CreditoRapido> creditoRapido = creditoRapidoService.creditoPorTomador(tomador);
        return creditoRapido.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{tomador}/aprovar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void aprovarCredito(@PathVariable Long tomador) {
        creditoRapidoService.aprovarCredito(tomador);
    }

    @DeleteMapping("/{tomador}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarCredito(@PathVariable Long tomador) {
        creditoRapidoService.cancelarCredito(tomador);
    }

}