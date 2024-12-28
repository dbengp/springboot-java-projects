package com.simple.api_web.repository;

import com.simple.api_web.model.TomadorDoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TomadorDeCreditoRepository extends JpaRepository<TomadorDoCredito, Long> {
}