package com.agendei.projetoagendei.repository.carWash;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendei.projetoagendei.model.carWash.CarWashModel;;

@Repository
public interface CarWashRepository extends JpaRepository<CarWashModel, UUID>{
    
}
