package com.agendei.projetoagendei.model.carWashAppointment;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Car_Washes_Appointment")
public class CarWashAppointmentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    // Declaração de variáveis
    private UUID carWashAppointmentId;
    private String userId;
    private String carWashId;
    private String dateCarWashAppointment;
    private String hourCarWashAppointment;
    private String carWashAppointmentState;

    public UUID getCarWashAppointmentId() {
        return carWashAppointmentId;
    }

    public void setCarWashAppointmentId(UUID carWashAppointmentId) {
        this.carWashAppointmentId = carWashAppointmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarWashId() {
        return carWashId;
    }

    public void setCarWashId(String carWashId) {
        this.carWashId = carWashId;
    }

    public String getDateCarWashAppointment() {
        return dateCarWashAppointment;
    }

    public void setDateCarWashAppointment(String dateCarWashAppointment) {
        this.dateCarWashAppointment = dateCarWashAppointment;
    }

    public String getHourCarWashAppointment() {
        return hourCarWashAppointment;
    }

    public void setHourCarWashAppointment(String hourCarWashAppointment) {
        this.hourCarWashAppointment = hourCarWashAppointment;
    }

    public String getCarWashAppointmentState() {
        return carWashAppointmentState;
    }
    
    public void setCarWashAppointmentState(String carWashAppointmentState) {
        this.carWashAppointmentState = carWashAppointmentState;
    }

}
