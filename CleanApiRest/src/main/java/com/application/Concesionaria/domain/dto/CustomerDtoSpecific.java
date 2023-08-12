package com.application.Concesionaria.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerDtoSpecific {
    private String cardId;
    private String fullName;
    private String email;
    private Integer numberCellPhone;
    private Integer active;

}
