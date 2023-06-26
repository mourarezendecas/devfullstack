package com.example.application.data.service;

import com.example.application.data.entity.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long>{
}
