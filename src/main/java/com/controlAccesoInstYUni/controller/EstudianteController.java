package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteRequestDTO;
import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteResponseDTO;
import com.controlAccesoInstYUni.application.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteResponseDTO> listar(){
        return estudianteService.listar();
    }

    @PostMapping
    public EstudianteResponseDTO guardar(@RequestBody EstudianteRequestDTO requestDTO){
        return estudianteService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO obtenerEstudiantePorID(@PathVariable Long id){
        return estudianteService.obtenerEstudiantePorID(id);
    }
}
