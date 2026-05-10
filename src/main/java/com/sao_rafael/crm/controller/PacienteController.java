package com.sao_rafael.crm.controller;

import com.sao_rafael.crm.model.Medico;
import com.sao_rafael.crm.model.Paciente;
import com.sao_rafael.crm.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping
    public List<Paciente> listarTodosMedicos(){
        return service.listarTodosPaciente();
    }

    @PostMapping
    public void cadastrarPaciente(@RequestBody Paciente paciente){
        service.cadastrarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id){
        service.removerPaciente(id);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> listarTodosPacientes(@PathVariable Long id){
        return service.listarPaciente(id);
    }
}