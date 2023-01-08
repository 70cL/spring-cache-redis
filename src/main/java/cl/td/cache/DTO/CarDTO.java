package cl.td.cache.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CarDTO {
    private String model;
    private String manufacturer;
}
