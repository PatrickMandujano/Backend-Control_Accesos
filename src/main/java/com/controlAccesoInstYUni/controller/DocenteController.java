package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.docente.DocenteRequestDTO;
import com.controlAccesoInstYUni.application.dto.docente.DocenteResponseDTO;
import com.controlAccesoInstYUni.application.service.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteController {
    private final DocenteService docenteService;

    @GetMapping
    public List<DocenteResponseDTO> listar(){
        return docenteService.listar();
    }

    @PostMapping
    public DocenteResponseDTO guardar(@RequestBody DocenteRequestDTO requestDTO){
        return docenteService.guardar(requestDTO);
    }

    @PostMapping("/{id}")
    public DocenteResponseDTO obtenerDocentePorID(@PathVariable Long id){
        return docenteService.obtenerDocentePorID(id);
    }
}
