package com.gerenciator.ufinance.repository;

import com.gerenciator.ufinance.modelo.entity.receita.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
