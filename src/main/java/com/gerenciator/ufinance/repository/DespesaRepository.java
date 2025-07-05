package com.gerenciator.ufinance.repository;

import com.gerenciator.ufinance.modelo.entity.despesa.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    void deleteDespesaById(Long id);
}
