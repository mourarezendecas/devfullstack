package com.grupo1.services;

import com.grupo1.entities.Nutricionista;
import com.grupo1.repositories.NutricionistaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthHelper {
    private final NutricionistaRepository nutricionistaRepository;

    public AuthHelper(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }

    public boolean logarNutri(String CRN, String senha){
        Nutricionista nutricionistaEncontrado = nutricionistaRepository.findByCRN(CRN);
        if(nutricionistaEncontrado.getSenha().equals(senha)){
            return true;
        }
        return false;
    }
}
