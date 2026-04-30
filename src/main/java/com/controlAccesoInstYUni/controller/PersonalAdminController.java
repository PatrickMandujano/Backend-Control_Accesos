package com.controlAccesoInstYUni.controller;

import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminRequestDTO;
import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminResponseDTO;
import com.controlAccesoInstYUni.application.service.PersonalAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personalAdministrativo")
@RequiredArgsConstructor
public class PersonalAdminController {
    private final PersonalAdminService personalAdminService;

    @GetMapping
    public List<PersonalAdminResponseDTO> listar(){
        return personalAdminService.listar();
    }

    @PostMapping
    public PersonalAdminResponseDTO guardar(@RequestBody PersonalAdminRequestDTO requestDTO){
        return personalAdminService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public PersonalAdminResponseDTO obtenerPersonalAdminPorID(@PathVariable Long id){
        return personalAdminService.obtenerPersonalAdminPorID(id);
    }

}
