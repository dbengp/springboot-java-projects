package com.system.takea_cab.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabbyRepository extends JpaRepository<Cabby, Long> {
}