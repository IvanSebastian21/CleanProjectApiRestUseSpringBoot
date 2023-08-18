package com.application.Concesionaria.domain.repository;

import com.application.Concesionaria.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {

    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer idCar);

    List<CarDto> getByPriceLessThan(Double priceCar);

    Optional<CarDto> getCarDtoByCodeCar(Integer codeCar);

    CarDto save(CarDto newCarDto);

    void delete(Integer codeCar);
}
