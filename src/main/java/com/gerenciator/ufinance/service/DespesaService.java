package com.gerenciator.ufinance.service;

import com.gerenciator.ufinance.modelo.entity.despesa.Despesa;
import com.gerenciator.ufinance.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa saveDespesa(Despesa despesa){
        return despesaRepository.save(despesa);
    }

    public boolean deleteDespesa(Long id){
        try{
            despesaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("Erro ao deletar despesa: " + e.getMessage());
            return false;
        }
    }

    public Despesa findDespesaById(Long id){
        return despesaRepository.findById(id).get();
    }

    public List<Despesa> findAllDespesa(){
        return despesaRepository.findAll();
    }

}
