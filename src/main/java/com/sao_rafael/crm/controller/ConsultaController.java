package com.sao_rafael.crm.controller;

import com.sao_rafael.crm.model.ConsultaMedica;
import com.sao_rafael.crm.service.ConsultaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaMedicaService service;

    @GetMapping
    public List<ConsultaMedica> listarConsultas(){
        return service.listarConsultas();
    }

    @GetMapping("medicos/{id}")
    public List<ConsultaMedica> listarConsultasPorMedico(@PathVariable Long id){
        return service.listarConsultasMedico(id);
    }

    @GetMapping("pacientes/{id}")
    public List<ConsultaMedica> listarConsultasPorPaciente(@PathVariable Long id){
        return service.listarConsultasPaciente(id);
    }

    @PostMapping
    public void marcarConsulta(@RequestBody ConsultaMedica consultaMedica){
        service.marcarConsulta(consultaMedica);
    }

    @DeleteMapping("/{id}")
    public void desmarcarConsulta(@PathVariable Long id){
        service.desmarcarConsulta(id);
    }
}
