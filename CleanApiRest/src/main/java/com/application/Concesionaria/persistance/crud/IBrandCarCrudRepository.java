package com.application.Concesionaria.persistance.crud;

import com.application.Concesionaria.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {
}
