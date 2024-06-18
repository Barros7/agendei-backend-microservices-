package com.agendei.projetoagendei.controller.carWashAppointment;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.agendei.projetoagendei.dtos.carWashAppointment.CarWashAppointmentRecordDto;
import com.agendei.projetoagendei.model.carWashAppointment.CarWashAppointmentModel;
import com.agendei.projetoagendei.repository.carWashAppointment.CarWashAppointmentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CarWashAppointmentController {
    
    @Autowired
    CarWashAppointmentRepository carWashAppointmentRepository;
    
    // Post new record
    @PostMapping("/car-wash-appointment")
    public ResponseEntity<CarWashAppointmentModel> saveCarWashAppointment(@RequestBody @Valid CarWashAppointmentRecordDto carWashAppointmentRecordDto) {
        var carWashAppointmentModel = new CarWashAppointmentModel();
        BeanUtils.copyProperties(carWashAppointmentRecordDto, carWashAppointmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carWashAppointmentRepository.save(carWashAppointmentModel));
    }
    
    // Get all record carWash
    @GetMapping("/car-wash-appointment")
    public ResponseEntity<List<CarWashAppointmentModel>> getAllCarWashAppointment() {
        return ResponseEntity.status(HttpStatus.OK).body(carWashAppointmentRepository.findAll());
    }
    
    // Get unique record carWash
    @GetMapping("/car-wash-appointment/{id}")
    public ResponseEntity<Object> getOneCarWashAppointment(@PathVariable(value="id") UUID id) {
        Optional<CarWashAppointmentModel> carWashAppointmentModel = carWashAppointmentRepository.findById(id);
        if(carWashAppointmentModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carWashAppointmentModel.get());
    }
    
    // Update carWash record
    @PutMapping("/car-wash-appointment/{id}")
    public ResponseEntity<Object> updateCarWashAppointment(@PathVariable(value = "id") UUID id, @RequestBody @Valid CarWashAppointmentRecordDto carWashAppointmentRecordDto) {
        Optional<CarWashAppointmentModel> carWash = carWashAppointmentRepository.findById(id);
        if(carWash.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        var carWashAppointmentModel = carWash.get();
        BeanUtils.copyProperties(carWashAppointmentRecordDto, carWashAppointmentModel);
        return ResponseEntity.status(HttpStatus.OK).body(carWashAppointmentRepository.save(carWashAppointmentModel));
    }
    
    // Delete carWash record
    @DeleteMapping("/car-wash-appointment/{id}")
    public ResponseEntity<Object> deleteCarWashAppointment(@PathVariable(value = "id") UUID id) {
        Optional<CarWashAppointmentModel> carWash = carWashAppointmentRepository.findById(id);
        if(carWash.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        carWashAppointmentRepository.delete(carWash.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
    }
}
