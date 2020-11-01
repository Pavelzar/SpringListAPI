package org.springAPItest.SpringListAPI.Services;

import org.springAPItest.SpringListAPI.Database.CarRepository;
import org.springAPItest.SpringListAPI.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarRepository carRepository;

    public Optional<Car> getCar(String id) {
        return carRepository.findById(id);
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> deleteCar(String id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            carRepository.deleteById(id);
        }
        return car;
    }

    public Car addCar(Car car) {
        car = carRepository.save(car);
        return car;
    }

}
