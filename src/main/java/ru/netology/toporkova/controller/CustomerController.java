package ru.netology.toporkova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.toporkova.controller.dto.CustomerDto;
import ru.netology.toporkova.domain.Customer;
import ru.netology.toporkova.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public CustomerDto postCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);

        return new CustomerDto(customer.getId(), customer.getName());
    }

    @GetMapping
    public Iterable<CustomerDto> getCustomers() {
        List<CustomerDto> customersDTO = new ArrayList<>();

        for (Customer customer : customerService.getCustomers()) {
            customersDTO.add(new CustomerDto(customer.getId(), customer.getName()));
        }

        return customersDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id) {
        for(Customer customer : customerService.getCustomers()){
            if(customer.getId().equals(id)){
                return new ResponseEntity<>(new CustomerDto(customer.getId(), customer.getName()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
