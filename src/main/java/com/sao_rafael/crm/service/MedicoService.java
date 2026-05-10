package com.sao_rafael.crm.service;

import com.sao_rafael.crm.model.Medico;
import com.sao_rafael.crm.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public List<Medico> listarTodosMedicos(){
        return repository.findAll();

    }
    public Optional<Medico> listarMedico(Long id){
        return repository.findById(id);
    }

    public void cadastrarMedico(Medico medico){
        repository.save(medico);
    }

    public void removerMedico(Long id){
        repository.deleteById(id);
    }
}
