package com.gerenciator.ufinance.controller;

import com.gerenciator.ufinance.modelo.entity.despesa.Despesa;
import com.gerenciator.ufinance.modelo.enumeration.categoria.Categoria;
import com.gerenciator.ufinance.service.DespesaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @RequestMapping("/despesa")
    public String despesa() {return "redirect:/html/despesa.html";}

    @RequestMapping("/despesa-cadastrar")
    public String despesaCadastrar(
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("day") int day,
            @RequestParam("categoria") String category
    ) {

        price = price.replace(".", "");
        price = price.replace(",", ".");

        Despesa  despesa = new Despesa();
        despesa.setName(name);
        despesa.setPrice(Float.parseFloat(price));
        despesa.setDay(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), day));
        despesa.setCategory(Categoria.valueOf(category));

        despesaService.saveDespesa(despesa);


        return "redirect:/despesa";
    }


}
