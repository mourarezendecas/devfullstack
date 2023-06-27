package com.example.application.data.service;

import com.example.application.data.entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}
