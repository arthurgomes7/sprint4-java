package com.sao_rafael.crm.service;

import com.sao_rafael.crm.model.Medico;
import com.sao_rafael.crm.model.Paciente;
import com.sao_rafael.crm.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listarTodosPaciente(){
        return repository.findAll();

    }
    public Optional<Paciente> listarPaciente(Long id){
        return repository.findById(id);
    }

    public void cadastrarPaciente(Paciente paciente){
        repository.save(paciente);
    }

    public void removerPaciente(Long id){
        repository.deleteById(id);
    }
}
