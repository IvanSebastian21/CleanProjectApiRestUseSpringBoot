package com.application.Concesionaria.persistance.crud;

import com.application.Concesionaria.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByBrandCarId(Integer carId);

    //Sin query method @Query("SELECT c FROM CarEntity c WHERE c.price <= :price ORDER BY c.price DESC")
    List<CarEntity> findByPriceLessThanEqualOrderByPriceDesc(Double price);
}
