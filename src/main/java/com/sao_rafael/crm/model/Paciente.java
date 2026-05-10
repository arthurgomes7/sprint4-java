package com.sao_rafael.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente extends Pessoa{
    @OneToMany(mappedBy = "paciente",
    cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<ConsultaMedica> consultaMedicaList;
}
