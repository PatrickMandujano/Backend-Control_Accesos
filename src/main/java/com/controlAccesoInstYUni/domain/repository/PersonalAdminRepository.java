package com.controlAccesoInstYUni.domain.repository;

import com.controlAccesoInstYUni.domain.entity.PersonalAdministrativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalAdminRepository extends JpaRepository<PersonalAdministrativo, Long> {

}
