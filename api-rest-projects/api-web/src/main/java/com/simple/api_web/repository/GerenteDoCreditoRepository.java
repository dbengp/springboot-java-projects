package com.simple.api_web.repository;

import com.simple.api_web.model.GerenteDoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteDoCreditoRepository extends JpaRepository<GerenteDoCredito, Long> {
}
