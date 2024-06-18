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
public class CarWashController {
    
    @Autowired
    CarWashRepository carWashRepository;
    
    // Post new record
    @PostMapping("/car-wash")
    public ResponseEntity<CarWashModel> saveCarWash(@RequestBody @Valid CarWashRecordDto carWashRecordDto) {
        var carWashModel = new CarWashModel();
        BeanUtils.copyProperties(carWashRecordDto, carWashModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carWashRepository.save(carWashModel));
    }
    
    // Get all record carWash
    @GetMapping("/car-wash")
    public ResponseEntity<List<CarWashModel>> getAllCarWashs() {
        return ResponseEntity.status(HttpStatus.OK).body(carWashRepository.findAll());
    }
    
    // Get unique record carWash
    @GetMapping("/car-wash/{id}")
    public ResponseEntity<Object> getOneCarWash(@PathVariable(value="id") UUID id) {
        Optional<CarWashModel> carWashModel = carWashRepository.findById(id);
        if(carWashModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carWashModel.get());
    }
    
    // Update carWash record
    @PutMapping("/car-wash/{id}")
    public ResponseEntity<Object> updateCarWash(@PathVariable(value = "id") UUID id, @RequestBody @Valid CarWashRecordDto carWashRecordDto) {
        Optional<CarWashModel> carWash = carWashRepository.findById(id);
        if(carWash.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        var carWashModel = carWash.get();
        BeanUtils.copyProperties(carWashRecordDto, carWashModel);
        return ResponseEntity.status(HttpStatus.OK).body(carWashRepository.save(carWashModel));
    }
    
    // Delete carWash record
    @DeleteMapping("/car-wash/{id}")
    public ResponseEntity<Object> deleteCarWash(@PathVariable(value = "id") UUID id) {
        Optional<CarWashModel> carWash = carWashRepository.findById(id);
        if(carWash.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record!");
        }
        carWashRepository.delete(carWash.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
    }
}
