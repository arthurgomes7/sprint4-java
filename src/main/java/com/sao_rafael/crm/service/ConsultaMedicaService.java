package com.sao_rafael.crm.service;

import com.sao_rafael.crm.exceptions.ConsultaException;
import com.sao_rafael.crm.model.ConsultaMedica;
import com.sao_rafael.crm.repository.ConsultaRepository;
import com.sao_rafael.crm.repository.MedicoRepository;
import com.sao_rafael.crm.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaMedicaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<ConsultaMedica> listarConsultas(){
        return consultaRepository.findAll();
    }

    public List<ConsultaMedica> listarConsultasPaciente(Long id){
        if(!consultaRepository.existsById(id)){
            System.out.println("Não existe consultas para esse Paciente");
        }
        return consultaRepository.findAllByPaciente_Id(id);
    }

    public List<ConsultaMedica> listarConsultasMedico(Long id){
        if(!consultaRepository.existsById(id)){
            System.out.println("Não existe consultas para esse Médico");
        }
        return consultaRepository.findAllByMedico_Id(id);
    }

    public void marcarConsulta(ConsultaMedica consultaMedica){
        if (!medicoRepository.existsById(consultaMedica.getMedico().getId())){
            throw new ConsultaException("Médico não identificado");
        }
        if (!pacienteRepository.existsById(consultaMedica.getPaciente().getId())){
            throw new ConsultaException("Paciente não encontrado");
        }
        consultaRepository.save(consultaMedica);
        System.out.printf("chegou");
    }

    public void desmarcarConsulta(Long id){
        consultaRepository.deleteById(id);
    }
}