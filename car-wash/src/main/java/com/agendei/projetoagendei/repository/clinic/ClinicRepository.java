package com.agendei.projetoagendei.repository.clinic;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendei.projetoagendei.model.clinic.ClinicModel;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicModel, UUID>{
    
}
