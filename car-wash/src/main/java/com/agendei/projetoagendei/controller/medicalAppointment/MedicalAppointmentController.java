package com.agendei.projetoagendei.controller.medicalAppointment;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.agendei.projetoagendei.dtos.medicalAppointment.MedicalAppointmentRecordDto;
import com.agendei.projetoagendei.model.medicalAppointment.MedicalAppointmentModel;
import com.agendei.projetoagendei.repository.medicalAppointment.MedicalAppointmentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class MedicalAppointmentController {
    
    @Autowired
    MedicalAppointmentRepository medicalAppointmentRepository;
    
    // Post new record
    @PostMapping("/medical-appointments")
    public ResponseEntity<MedicalAppointmentModel> saveMedicalAppointment(@RequestBody @Valid MedicalAppointmentRecordDto medicalAppointmentRecordDto) {
        var medicalAppointmentModel = new MedicalAppointmentModel();
        BeanUtils.copyProperties(medicalAppointmentRecordDto, medicalAppointmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalAppointmentRepository.save(medicalAppointmentModel));
    }
    
    // Get all record medicalAppointment
    @GetMapping("/medical-appointments")
    public ResponseEntity<List<MedicalAppointmentModel>> getAllMedicalAppointments() {
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentRepository.findAll());
    }
    
    // Get unique record medicalAppointment
    @GetMapping("/medical-appointments/{id}")
    public ResponseEntity<Object> getOneMedicalAppointment(@PathVariable(value="id") UUID id) {
        Optional<MedicalAppointmentModel> medicalAppointmentModel = medicalAppointmentRepository.findById(id);
        if(medicalAppointmentModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentModel.get());
    }
    
    // Update medicalAppointment record
    @PutMapping("/medical-appointments/{id}")
    public ResponseEntity<Object> updateMedicalAppointment(@PathVariable(value = "id") UUID id, @RequestBody @Valid MedicalAppointmentRecordDto medicalAppointmentRecordDto) {
        Optional<MedicalAppointmentModel> medicalAppointment = medicalAppointmentRepository.findById(id);
        if(medicalAppointment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        var medicalAppointmentModel = medicalAppointment.get();
        BeanUtils.copyProperties(medicalAppointmentRecordDto, medicalAppointmentModel);
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentRepository.save(medicalAppointmentModel));
    }
    
    // Delete medicalAppointment record
    @DeleteMapping("/medical-appointments/{id}")
    public ResponseEntity<Object> deleteMedicalAppointment(@PathVariable(value = "id") UUID id) {
        Optional<MedicalAppointmentModel> medicalAppointment = medicalAppointmentRepository.findById(id);
        if(medicalAppointment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        medicalAppointmentRepository.delete(medicalAppointment.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
    }
}
