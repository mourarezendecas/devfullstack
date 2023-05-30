package com.grupo1.repositories;

import com.grupo1.entities.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Nutricionista findByCRN(String CRN);
}
