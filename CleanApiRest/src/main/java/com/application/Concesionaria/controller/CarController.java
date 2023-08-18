package com.application.Concesionaria.controller;

import com.application.Concesionaria.domain.dto.CarDto;
import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.useCase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    private final ICarService iCarService;

    @GetMapping("/get_all")
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iCarService.getAll());
    }

    @GetMapping("/get_by_id/{carId}")
    public ResponseEntity<CarDto> getCustomer(@PathVariable Integer carId) {
        return ResponseEntity.of(iCarService.getCarDtoByCodeCar(carId));
    }

    @GetMapping("/get_brand_card_id/{idBrandCard}")
    public ResponseEntity<List<CarDto>> getByIdBrandCard(@PathVariable Integer idBrandCard){
        return ResponseEntity.ok(iCarService.getByIdBrandCar(idBrandCard));
    }

    @GetMapping("/price/{priceCar}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThen(@PathVariable Double priceCar){
        return ResponseEntity.ok(iCarService.getByPriceLessThan(priceCar));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCar(@RequestBody CarDto newCarDto) {
        try{

        return ResponseEntity.status(HttpStatus.CREATED).body(iCarService.save(newCarDto));
        }    catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
      }

    @PatchMapping("/update")
    public ResponseEntity<CarDto> update(@RequestBody CarDto carDtoUpdate){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarService.save(carDtoUpdate));
    }

    @DeleteMapping("/delete/{carId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer carId) {
        return new ResponseEntity<>(this.iCarService.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
