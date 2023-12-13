package ru.netology.toporkova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.toporkova.controller.dto.CustomerDto;
import ru.netology.toporkova.controller.dto.CustomersGetResponse;
import ru.netology.toporkova.domain.Customer;
import ru.netology.toporkova.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public CustomersGetResponse getCustomers() {
        List<CustomerDto> customersDTO = new ArrayList<>();

        for (Customer customer : customerService.getCustomers()) {
            customersDTO.add(new CustomerDto(customer.getId(), customer.getName()));
        }

        return new CustomersGetResponse(customersDTO);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Integer id) {
        for(Customer customer : customerService.getCustomers()){
            if(customer.getId().equals(id)){
                return new CustomerDto(customer.getId(), customer.getName());
            }
        }
        return null;
    }

    @PostMapping("/{customerId}")
    public void addCustomer(@RequestBody  Customer customer){
        customerService.addCustomer(customer.getId(), customer.getName());
    }

    @DeleteMapping("{customerId}")
    public void removeCustomer(@PathVariable int customerId) {
        customerService.removeCustomer(customerId);
    }
}
