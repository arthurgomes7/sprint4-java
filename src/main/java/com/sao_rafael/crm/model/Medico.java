package com.sao_rafael.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TB_MEDICO")
public class Medico extends Pessoa {
    @Column(name = "ESPECIALIDADE")
    private String especialidade;
    @Column(name = "CRM", nullable = false, unique = true)
    private String crm;

    @OneToMany(mappedBy = "medico",
            cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<ConsultaMedica> consultaMedicaList;
}