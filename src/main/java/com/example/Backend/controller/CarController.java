package com.example.Backend.controller;

import com.example.Backend.Entity.Car;
import com.example.Backend.repository.CarRepository;
import com.example.Backend.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car savedCar = carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car updatedCar){
        Car updated = carService.updateCar(id, updatedCar);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getallCars")
    public ResponseEntity<List<Car>> getAllCar(){
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }
}
