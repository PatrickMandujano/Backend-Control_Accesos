package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaRequestDTO;
import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaResponseDTO;
import com.controlAccesoInstYUni.application.service.UsuarioService;
import com.controlAccesoInstYUni.application.service.RegPermanenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/registrosPermanencia")
@RequiredArgsConstructor
public class RegistroPermanenciaController {
    private final RegPermanenciaService regPermanenciaService;
    private final UsuarioService usuarioService;

    @GetMapping
    public List<RegPermanenciaResponseDTO> listar(){
        return regPermanenciaService.listarRegPermanencia();
    }

    @GetMapping("/{id}")
    public RegPermanenciaResponseDTO obtenerRegPermanenciaPorID(@PathVariable Long id){
        return regPermanenciaService.obtenerRegPermanenciaPorID(id);
    }

    @PostMapping("/entrada")
    public ResponseEntity<RegPermanenciaResponseDTO> registrarEntrada(@RequestBody RegPermanenciaRequestDTO requestDTO) {
        return ResponseEntity.ok(regPermanenciaService.registrarEntrada(requestDTO));
    }

    @PutMapping("/salida")
    public ResponseEntity<RegPermanenciaResponseDTO> registrarSalida(@RequestBody RegPermanenciaRequestDTO requestDTO) {
        return ResponseEntity.ok(regPermanenciaService.registrarSalida(requestDTO));
    }
}
