package com.agendei.projetoagendei.controller.clinic;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.agendei.projetoagendei.dtos.clinic.ClinicRecordDto;
import com.agendei.projetoagendei.model.clinic.ClinicModel;
import com.agendei.projetoagendei.repository.clinic.ClinicRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class ClinicController {

    @Autowired
    ClinicRepository clinicRepository;
    
    // Post new record
    @PostMapping("/clinics")
    public ResponseEntity<ClinicModel> saveClinic(@RequestBody @Valid ClinicRecordDto clinicRecordDto) {
        var clinicModel = new ClinicModel();
        BeanUtils.copyProperties(clinicRecordDto, clinicModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clinicRepository.save(clinicModel));
    }
    
    // Get all record clinic
    @GetMapping("/clinics")
    public ResponseEntity<List<ClinicModel>> getAllClinics() {
        return ResponseEntity.status(HttpStatus.OK).body(clinicRepository.findAll());
    }
    
    // Get unique record clinic
    @GetMapping("/clinics/{id}")
    public ResponseEntity<Object> getOneClinic(@PathVariable(value="id") UUID id) {
        Optional<ClinicModel> clinicModel = clinicRepository.findById(id);
        if(clinicModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clinicModel.get());
    }

    // Update clinic record
    @PutMapping("/clinics/{id}")
    public ResponseEntity<Object> updateClinic(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClinicRecordDto clinicRecordDto) {
        Optional<ClinicModel> clinic = clinicRepository.findById(id);
        if(clinic.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        var clinicModel = clinic.get();
        BeanUtils.copyProperties(clinicRecordDto, clinicModel);
        return ResponseEntity.status(HttpStatus.OK).body(clinicRepository.save(clinicModel));
    }

    // Delete clinic record
    @DeleteMapping("/clinics/{id}")
    public ResponseEntity<Object> deleteClinic(@PathVariable(value = "id") UUID id) {
        Optional<ClinicModel> clinic = clinicRepository.findById(id);
        if(clinic.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        clinicRepository.delete(clinic.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
    }
}
