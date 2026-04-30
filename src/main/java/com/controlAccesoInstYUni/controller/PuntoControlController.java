package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlRequestDTO;
import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlResponseDTO;
import com.controlAccesoInstYUni.application.service.PuntoControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puntoControl")
@RequiredArgsConstructor
public class PuntoControlController {
    private final PuntoControlService puntoControlService;

    @PostMapping("/todosPuntosControl")
    public List<PuntoControlResponseDTO> guardarPuntosControl(@RequestBody List<PuntoControlRequestDTO> requestDTO){
        return puntoControlService.guardarPuntosControl(requestDTO);
    }

    @GetMapping
    public List<PuntoControlResponseDTO>listarPuntosControl(){
        return puntoControlService.listarPuntosControl();
    }

    @PostMapping
    public PuntoControlResponseDTO guardar(@RequestBody PuntoControlRequestDTO requestDTO){
        return puntoControlService.guardar(requestDTO);

    }

    @GetMapping("/{id}")
    public PuntoControlResponseDTO listarPorId(@PathVariable Long id){
        return puntoControlService.obtenerPuntoControlPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        puntoControlService.eliminar(id);
    }
}
