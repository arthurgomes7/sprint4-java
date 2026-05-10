package com.sao_rafael.crm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DOCUMENTO", nullable = false, unique = true)
    private String documento;
    @Column(name = "NUMERO_DE_TELEFONE", unique = true)
    private String numeroTelefone;
}
