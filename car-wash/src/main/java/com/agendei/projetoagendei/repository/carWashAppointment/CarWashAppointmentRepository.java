package com.agendei.projetoagendei.repository.carWashAppointment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendei.projetoagendei.model.carWashAppointment.CarWashAppointmentModel;;

@Repository
public interface CarWashAppointmentRepository extends JpaRepository<CarWashAppointmentModel, UUID>{
    
}
