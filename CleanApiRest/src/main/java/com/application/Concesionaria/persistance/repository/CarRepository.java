package com.application.Concesionaria.persistance.repository;

import com.application.Concesionaria.domain.dto.CarDto;
import com.application.Concesionaria.domain.repository.ICarRepository;
import com.application.Concesionaria.persistance.entity.CarEntity;
import com.application.Concesionaria.persistance.mapper.ICarMapper;
import com.application.Concesionaria.persistance.crud.ICarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;

    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idCar) {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findAllByBrandCarId(idCar));
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double priceCar) {
        return iCarMapper.toCarsDtoList(iCarCrudRepository.findByPriceLessThanEqualOrderByPriceDesc(priceCar));
    }

    @Override
    public Optional<CarDto> getCarDtoByCodeCar(Integer codeCar) {
        return iCarCrudRepository
                .findById(codeCar)
                .map(carEntity -> iCarMapper.toCarDto(carEntity));
    }

    @Override
    public CarDto save(CarDto newCarDto) {
        CarEntity carEntity = iCarMapper.toCarEntity(newCarDto);
        return iCarMapper.toCarDto(iCarCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Integer codeCar) {
        iCarCrudRepository.deleteById(codeCar);

    }
}
