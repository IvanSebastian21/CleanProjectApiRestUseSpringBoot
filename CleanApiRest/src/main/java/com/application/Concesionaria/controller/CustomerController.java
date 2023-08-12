package com.application.Concesionaria.controller;

import com.application.Concesionaria.domain.dto.CustomerDto;
import com.application.Concesionaria.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping("/get_all")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iCustomerService.getAll());
    }

    @GetMapping("/get_by_card_id/{cardId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerService.getCustomerDtoCarId(cardId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerService.getCustomerDtoByEmail(email));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto newCustomerDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerService.save(newCustomerDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate) {
        return ResponseEntity.of(iCustomerService.update(customerDtoUpdate));
    }

    @PostMapping("/generated_password")
    public ResponseEntity<?> generatedPassword(@RequestBody CustomerDto newPasswordCustomerDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerService.getPasswordGenerationDto(newPasswordCustomerDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(this.iCustomerService.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
