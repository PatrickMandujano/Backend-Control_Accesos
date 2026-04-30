package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listar(){
        return usuarioService.listar();
    }

    @GetMapping("buscarPorCodAcceso/{codAcceso}")
    public UsuarioResponseDTO findByCodigoAcceso(@PathVariable String codAcceso){
        return usuarioService.findByCodigoAcceso(codAcceso);
    }

    @PostMapping("/todosUsuarios")
    public List<UsuarioResponseDTO> guardarUsuarios(@RequestBody List<UsuarioRequestDTO> requestDTOs){
        return usuarioService.guardarUsuarios(requestDTOs);
    }

    @PostMapping
    public UsuarioResponseDTO guardar(@RequestBody UsuarioRequestDTO requestDTO){
        return usuarioService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtener(@PathVariable Long id){
        return usuarioService.obtenerUsuarioPorId(id);
    }


}
