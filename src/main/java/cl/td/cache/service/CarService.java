package cl.td.cache.service;

import cl.td.cache.entity.Car;
import cl.td.cache.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements VehicleService{

    private final CarRepository carRepository;

    @Override
    @Cacheable(cacheNames = "cars")
    public List<Car> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return carRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "car", key = "#id")
    public Car findOne(Long id) throws InterruptedException {
        Thread.sleep(5000);
        return carRepository.findById(id).orElse(new Car(999L,"Lambo","Lambo"));
    }

    @Override
    @CachePut(cacheNames = "car", key = "#newCar.id")
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public Car newCar(Car newCar) throws InterruptedException {
        Thread.sleep(5000);
        return carRepository.save(newCar);
    }

    @Override
    @CachePut(cacheNames = "car", key = "#newCar.id")
    @CacheEvict(cacheNames = "cars", allEntries = true)
    public Car update(Car newCar) throws InterruptedException {
        Thread.sleep(5000);
        return carRepository.save(newCar);
    }
}
