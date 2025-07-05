package com.gerenciator.ufinance.controller;

import com.gerenciator.ufinance.modelo.entity.despesa.Despesa;
import com.gerenciator.ufinance.modelo.entity.receita.Receita;
import com.gerenciator.ufinance.repository.DespesaRepository;
import com.gerenciator.ufinance.repository.ReceitaRepository;
import com.gerenciator.ufinance.service.DespesaService;
import com.gerenciator.ufinance.service.ReceitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RelatorioController {

    public final ReceitaService receitaService;
    public final ReceitaRepository receitaRepository;
    public final DespesaService despesaService;
    public final DespesaRepository despesaRepository;


    public RelatorioController(ReceitaService receitaService,  DespesaService despesaService,  DespesaRepository despesaRepository,  ReceitaRepository receitaRepository) {
        this.receitaService = receitaService;
        this.despesaService = despesaService;
        this.despesaRepository = despesaRepository;
        this.receitaRepository = receitaRepository;
    }

    @GetMapping("/api/despesa")
    public Map<String, Float> relatorioDespesa(){
        Map<String, Float> map = new HashMap<>();

        for(Despesa despesa : despesaRepository.findAll()){
            boolean exists = false;
            for (Map.Entry<String, Float> entry : map.entrySet()){
                if (despesa.getCategory().toString().equals(entry.getKey())) {
                    entry.setValue(despesa.getPrice()+entry.getValue());
                    exists = true;
                    break;
                }
            }
            if(!exists){
                map.put(despesa.getCategory().toString(), despesa.getPrice());
            }
        }
        return map;
    }

    @GetMapping("/api/receita")
    public Map<String, Float> relatorioReceita(){
        Map<String, Float> map = new HashMap<>();
        float totalReceita = 0;
        float totalDespesa = 0;

        for (Receita receita : receitaService.findAllReceita()){
            totalReceita += receita.getPrice();
        }
        for (Despesa despesa : despesaService.findAllDespesa()){
            totalDespesa += despesa.getPrice();
        }

        map.put("Receita", totalReceita);
        map.put("Despesa", totalDespesa);
        return map;
    }

}
