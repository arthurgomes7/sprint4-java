package com.sao_rafael.crm.controller;

import com.sao_rafael.crm.model.Medico;
import com.sao_rafael.crm.repository.MedicoRepository;
import com.sao_rafael.crm.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping
    public List<Medico> listarTodosMedicos(){
        return service.listarTodosMedicos();
    }

    @PostMapping
    public void cadastrarMedico(@RequestBody Medico medico){
        service.cadastrarMedico(medico);
    }

    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id){
        service.removerMedico(id);
    }

    @GetMapping("/{id}")
    public Optional<Medico> listarTodosMedicos(@PathVariable Long id){
        return service.listarMedico(id);
    }
}
