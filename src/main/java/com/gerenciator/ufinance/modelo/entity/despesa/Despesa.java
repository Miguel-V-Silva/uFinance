package com.gerenciator.ufinance.modelo.entity.despesa;

import com.gerenciator.ufinance.modelo.enumeration.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate day;
    private float price;
    @Enumerated(EnumType.STRING)
    private Categoria category;
}
