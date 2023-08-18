package com.application.Concesionaria.persistance.crud;

import com.application.Concesionaria.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    //Sin Query Method --> @Query("SELECT c FROM CustomerEntity c WHERE c.email = :email")
    //Con Query Method
    Optional<CustomerEntity> findByEmail(String email);
}
