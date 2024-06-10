package com.agendei.projetoagendei.model.carWash;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEDICAL_APPOINTMENTS")
public class CarWashModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    // Declaração de variáveis
    private UUID medicalAppointmentId;
    private String patientId;
    private String dateMedicalAppointment;
    private String hourMedicalAppointment;
    private String medicalAppointmentState;

    // Definição dos Getters e Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDateMedicalAppointment() {
        return dateMedicalAppointment;
    }

    public void setDateMedicalAppointment(String dateMedicalAppointment) {
        this.dateMedicalAppointment = dateMedicalAppointment;
    }

    public String getHourMedicalAppointment() {
        return hourMedicalAppointment;
    }

    public void setHourMedicalAppointment(String hourMedicalAppointment) {
        this.hourMedicalAppointment = hourMedicalAppointment;
    }

    public String getMedicalAppointmentState() {
        return medicalAppointmentState;
    }

    public void setMedicalAppointmentState(String medicalAppointmentState) {
        this.medicalAppointmentState = medicalAppointmentState;
    }
}
