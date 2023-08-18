package com.application.Concesionaria.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarDto {
    private Integer codeCar;
    private Integer brandCarId;
    private String reference;
    private Double price;
    private String modelYear;
    private String color;
    private Double numberHorsePower;
    private Integer numberOfDoors;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private Integer traction;
    private String steering;
    private String category;
    private String imagePath;

}
