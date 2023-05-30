package com.example.application.repositories;

import com.example.application.models.Apartamento;
import com.example.application.models.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
    public List<Apartamento> findByEdificio(Edificio edificio);
}
