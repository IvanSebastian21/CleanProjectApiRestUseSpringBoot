package com.application.Concesionaria.domain.service;

import com.application.Concesionaria.domain.dto.CarDto;
import com.application.Concesionaria.domain.repository.ICarRepository;
import com.application.Concesionaria.domain.useCase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarService {

    private final ICarRepository iCarRepository;

    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarRepository.getByIdBrandCar(idBrandCar);
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double priceCar) {
        return iCarRepository.getByPriceLessThan(priceCar);
    }

    @Override
    public Optional<CarDto> getCarDtoByCodeCar(Integer codeCar) {
        return iCarRepository.getCarDtoByCodeCar(codeCar);
    }

    @Override
    public CarDto save(CarDto newCarDto) {
        return iCarRepository.save(newCarDto);
    }

    @Override
    public Optional<CarDto> update(CarDto newCarDto){
        if(iCarRepository.getCarDtoByCodeCar(newCarDto.getCodeCar()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCarRepository.save(newCarDto));
    }

    @Override
    public boolean delete(Integer codeCar) {
        if (iCarRepository.getCarDtoByCodeCar(codeCar).isEmpty()) {
            return false;
        }

        iCarRepository.delete(codeCar);
        return true;
    }
}
