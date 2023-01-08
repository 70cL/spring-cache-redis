package cl.td.cache.controller;

import cl.td.cache.DTO.CarDTO;
import cl.td.cache.entity.Car;
import cl.td.cache.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car-service")
@RequiredArgsConstructor
public class CarController {
    private final VehicleService vehicleService;

    @GetMapping(value = "get-all-car")
    public ResponseEntity<List<Car>> getAllCar() throws InterruptedException {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "get-car")
    public ResponseEntity<Car> getCar(@RequestParam Long id) throws InterruptedException {
        Car car = vehicleService.findOne(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping(value = "save-car")
    public ResponseEntity<Car> saveCar(@RequestBody CarDTO carDTO) throws InterruptedException {
        Car car = new Car(carDTO.getModel(), carDTO.getManufacturer());
        vehicleService.newCar(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "update-car")
    public ResponseEntity<Car> updateCar(@RequestBody Car newCar) throws InterruptedException {
        return new ResponseEntity<>(vehicleService.update(newCar), HttpStatus.OK);
    }
}
