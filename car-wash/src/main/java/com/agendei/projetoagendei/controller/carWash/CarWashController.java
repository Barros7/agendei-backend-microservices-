package com.agendei.projetoagendei.controller.carWash;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.agendei.projetoagendei.dtos.carWash.CarWashRecordDto;
import com.agendei.projetoagendei.model.carWash.CarWashModel;
import com.agendei.projetoagendei.repository.carWash.CarWashRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class CarWashController {
    
    @Autowired
    CarWashRepository carWashRepository;
    
    // Post new record
    @PostMapping("/car-wash")
    public ResponseEntity<CarWashModel> saveMedicalAppointment(@RequestBody @Valid CarWashRecordDto medicalAppointmentRecordDto) {
        var medicalAppointmentModel = new CarWashModel();
        BeanUtils.copyProperties(medicalAppointmentRecordDto, medicalAppointmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carWashRepository.save(medicalAppointmentModel));
    }
    
    // Get all record medicalAppointment
    @GetMapping("/car-wash")
    public ResponseEntity<List<CarWashModel>> getAllMedicalAppointments() {
        return ResponseEntity.status(HttpStatus.OK).body(carWashRepository.findAll());
    }
    
    // Get unique record medicalAppointment
    @GetMapping("/car-wash/{id}")
    public ResponseEntity<Object> getOneMedicalAppointment(@PathVariable(value="id") UUID id) {
        Optional<CarWashModel> medicalAppointmentModel = carWashRepository.findById(id);
        if(medicalAppointmentModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentModel.get());
    }
    
    // Update medicalAppointment record
    @PutMapping("/car-wash/{id}")
    public ResponseEntity<Object> updateMedicalAppointment(@PathVariable(value = "id") UUID id, @RequestBody @Valid CarWashRecordDto medicalAppointmentRecordDto) {
        Optional<CarWashModel> medicalAppointment = carWashRepository.findById(id);
        if(medicalAppointment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        var medicalAppointmentModel = medicalAppointment.get();
        BeanUtils.copyProperties(medicalAppointmentRecordDto, medicalAppointmentModel);
        return ResponseEntity.status(HttpStatus.OK).body(carWashRepository.save(medicalAppointmentModel));
    }
    
    // Delete medicalAppointment record
    @DeleteMapping("/car-wash/{id}")
    public ResponseEntity<Object> deleteMedicalAppointment(@PathVariable(value = "id") UUID id) {
        Optional<CarWashModel> medicalAppointment = carWashRepository.findById(id);
        if(medicalAppointment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        carWashRepository.delete(medicalAppointment.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
    }
}
