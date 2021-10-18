/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Car;
import co.usa.mintic.ciclo3.ciclo3.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Formacion
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int id) {
        return carRepository.getCar(id);
    }

    public Car save(Car c) {
        if (c.getId() == null) {
            return carRepository.save(c);
        } else {
            Optional<Car> caux = carRepository.getCar(c.getId());
            if (!caux.isPresent()) {
                return carRepository.save(c);
            } else {
                return c;
            }
        }
    }
    
}
