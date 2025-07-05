package com.gerenciator.ufinance.service;

import com.gerenciator.ufinance.modelo.entity.receita.Receita;
import com.gerenciator.ufinance.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public Receita saveReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

    public boolean deleteReceita(Long id){
        try{
        receitaRepository.deleteById(id);
        return true;
        } catch(Exception e){
            return false;
        }
    }

    public Receita findReceitaById(Long id){
        return receitaRepository.findById(id).get();
    }

    public List<Receita> findAllReceita(){
        return receitaRepository.findAll();
    }
}
