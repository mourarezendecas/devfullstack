package com.dfs.repositories;

import com.dfs.model.NutricionistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutricionistaRepository extends JpaRepository<NutricionistaModel, Long> {
    NutricionistaModel findByCrn(String crn);
}
