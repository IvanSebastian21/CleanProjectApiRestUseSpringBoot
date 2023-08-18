package com.application.Concesionaria.domain.useCase;

import com.application.Concesionaria.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer idCar);

    List<CarDto> getByPriceLessThan(Double priceCar);

    Optional<CarDto> getCarDtoByCodeCar(Integer codeCar);

    CarDto save(CarDto newCarDto);
    Optional<CarDto> update(CarDto newCarDto);

    boolean delete(Integer codeCar);

}



