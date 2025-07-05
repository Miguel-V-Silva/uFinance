package com.gerenciator.ufinance.controller;

import com.gerenciator.ufinance.modelo.entity.receita.Receita;
import com.gerenciator.ufinance.service.ReceitaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }


    @RequestMapping("/receita")
    public String receita() {
        return "redirect:/html/receita.html";
    }

    @RequestMapping("/receita-cadastrar")
    public String cadastrasReceita(
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("day") int day
            ) throws IOException {


        price = price.replace(".", "");
        price = price.replace(",", ".");

        Receita receita = new Receita();
        receita.setName(name);
        receita.setPrice(Float.parseFloat(price));
        receita.setDay(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), day));

        receitaService.saveReceita(receita);
        return "redirect:/receita";
    }

    @RequestMapping("/relatorio")
    public String relatorio() {return "redirect:/html/relatorio.html";}

}
