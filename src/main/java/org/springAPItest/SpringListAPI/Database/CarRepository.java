package org.springAPItest.SpringListAPI.Database;

import org.springAPItest.SpringListAPI.Model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {

    @Override
    List<Car> findAll();

}
