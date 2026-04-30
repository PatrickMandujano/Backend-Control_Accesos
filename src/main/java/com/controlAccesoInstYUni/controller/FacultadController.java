package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.facultad.FacultadRequestDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.application.service.FacultadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facultad")
@RequiredArgsConstructor
public class FacultadController {
    private final FacultadService service;

    @PostMapping("/todasFacultades")
    public List<FacultadResponseDTO> guardarFacultades(@RequestBody List<FacultadRequestDTO> requestDTOs){
        return service.guardarFacultades(requestDTOs);
    }

    @GetMapping
    public List<FacultadResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public FacultadResponseDTO guardar(@RequestBody FacultadRequestDTO requestDTO){
        return service.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public FacultadResponseDTO obtenerFacultadPorId(@PathVariable Long id){
        return service.obtenerFacultadPorId(id);
    }

}
