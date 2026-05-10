package com.sao_rafael.crm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CONSULTAS")
public class ConsultaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_MEDICO", nullable = false)
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;
    @Column(name = "DATA_MARCADA", nullable = false)
    private LocalDateTime dataMarcada; //yyyy-MM-ddTHH:mm:ss
    @Column(name = "DESCRICAO")
    private String descricao;
}