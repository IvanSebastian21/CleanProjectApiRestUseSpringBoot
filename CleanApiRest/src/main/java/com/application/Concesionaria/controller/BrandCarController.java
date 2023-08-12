package com.application.Concesionaria.controller;

import com.application.Concesionaria.domain.dto.BrandCarDto;
import com.application.Concesionaria.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/brand_car")
public class BrandCarController {

    private final IBrandCarService iBrandCarService;

    @GetMapping("/get_all")
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
        //return ResponseEntity.ok(iBrandCarService.getAll()); //Alternativa
        // return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); Alternativa
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
//        Optional<BrandCarDto> brandCar = iBrandCarService.getBrandCar(id);
//        if (brandCar.isPresent()) {
//            return ResponseEntity.status(HttpStatus.OK).body(brandCar.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBrandCar(@RequestBody BrandCarDto newBrandCar) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iBrandCarService.save(newBrandCar));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarUpdate) {
        return ResponseEntity.of(iBrandCarService.update(brandCarUpdate));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBrandCar(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

//        boolean isDeleted = iBrandCarService.delete(id);
//        return ResponseEntity.of(Optional.ofNullable(isDeleted ? null : null));

//        if (isDeleted) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    }

}
