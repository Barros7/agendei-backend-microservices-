package com.agendei.projetoagendei.repository.medicalAppointment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendei.projetoagendei.model.medicalAppointment.MedicalAppointmentModel;;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointmentModel, UUID>{
    
}
