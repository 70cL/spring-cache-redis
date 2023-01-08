package cl.td.cache.service;

import cl.td.cache.entity.Car;

import java.util.List;

public interface VehicleService {
    List<Car> findAll() throws InterruptedException;

    Car findOne(Long id) throws InterruptedException;

    Car newCar(Car car) throws InterruptedException;

    Car update(Car car) throws InterruptedException;
}
