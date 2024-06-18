package com.agendei.projetoagendei.model.carWash;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Car_Washes")
public class CarWashModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    // Declaração de variáveis
    private UUID carWashId;
    private String dateCarWash;
    private String hourCarWash;
    private String carWashState;

    public String getDateCarWash() {
        return dateCarWash;
    }
    
    public void setDateCarWash(String dateCarWash) {
        this.dateCarWash = dateCarWash;
    }
    
    public String getHourCarWash() {
        return hourCarWash;
    }
    
    public void setHourCarWash(String hourCarWash) {
        this.hourCarWash = hourCarWash;
    }
    
    public String getCarWashState() {
        return carWashState;
    }
    
    public void setCarWashState(String carWashState) {
        this.carWashState = carWashState;
    }
}
