package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraRequestDTO;
import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.application.service.CarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrera")
@RequiredArgsConstructor
public class CarreraController {
    private final CarreraService service;

    @GetMapping
    public List<CarreraResponseDTO> listar(){return service.listar();}

    @PostMapping("/todasCarreras")
    public List<CarreraResponseDTO> guardarCarreras(@RequestBody List<CarreraRequestDTO> requestDTOs){
        return service.guardarCarreras(requestDTOs);
    }

    @PostMapping
    public CarreraResponseDTO guardar(@RequestBody CarreraRequestDTO requestDTO){
        return service.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public CarreraResponseDTO listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }
}
