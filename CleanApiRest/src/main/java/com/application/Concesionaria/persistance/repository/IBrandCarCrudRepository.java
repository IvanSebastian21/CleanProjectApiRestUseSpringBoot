package com.application.Concesionaria.persistance.repository;

import com.application.Concesionaria.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {
}
