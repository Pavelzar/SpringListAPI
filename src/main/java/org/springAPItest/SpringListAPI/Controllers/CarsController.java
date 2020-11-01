package org.springAPItest.SpringListAPI.Controllers;

import org.springAPItest.SpringListAPI.Model.*;
import org.springAPItest.SpringListAPI.Services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable String id) {
        return ResponseEntity.of(carsService.getCar(id));
    }

    @GetMapping("/cars")
    public List<Car> getCars() {

        return carsService.getAllCars();
    }

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Car> addCar(@RequestBody Car car) {

        if(car.getId()!=null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Car>(carsService.addCar(car), HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable String id) {
        return ResponseEntity.of(carsService.deleteCar(id));
    }

}
