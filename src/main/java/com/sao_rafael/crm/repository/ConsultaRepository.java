package com.sao_rafael.crm.repository;

import com.sao_rafael.crm.model.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaMedica, Long> {
    List<ConsultaMedica> findAllByPaciente_Id(Long id);
    List<ConsultaMedica> findAllByMedico_Id(Long id);
}
