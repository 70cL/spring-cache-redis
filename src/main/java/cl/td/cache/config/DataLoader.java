package cl.td.cache.config;

import cl.td.cache.entity.Car;
import cl.td.cache.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final CarRepository carRepository;

    @PostConstruct
    private void addData(){
        Car car = new Car("Alfa Romeo","MiTo");
        Car car1 = new Car("Alfa Romeo","The Giulia Quadrifoglio");

        Car car2 = new Car("BMW","X6");
        Car car3 = new Car("BMW","X3");

        Car car4 = new Car("Ferrari","488 Spider");
        Car car5 = new Car("Ferrari","Testa Rossa");

        Car car6 = new Car("Bugatti","Chiron");
        Car car7 = new Car("Bugatti","Veyron");

        List<Car> cars = new ArrayList<>();

        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        carRepository.saveAll(cars);
    }
}
