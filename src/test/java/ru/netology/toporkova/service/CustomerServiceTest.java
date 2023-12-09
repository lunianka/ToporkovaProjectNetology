package ru.netology.toporkova.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.controller.CustomerController;
import ru.netology.toporkova.controller.dto.CustomerDto;
import ru.netology.toporkova.controller.dto.CustomersGetResponse;
import ru.netology.toporkova.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest extends OperationHistoryApiApplicationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void getClientsTest() {
        assertEquals(new Customer(1, "Spring", "pass"), customerService.getCustomer(0));
        assertEquals(new Customer(2, "Boot", "pass"), customerService.getCustomer(1));
    }

    @Test
    public void saveInCustomerServiceTest(){
        int customerId = 5;
        String customerName = "John";
        String customerPassword = "12345";
        Customer john = new Customer(customerId, customerName, customerPassword);

        customerService.addCustomer(john);
        Customer customer = customerService.getCustomer(2);

        assertEquals(john, customer);
        assertEquals(customerId, customer.getId());
        assertEquals(customerName, customer.getName());
        assertEquals(customerPassword, customer.getPassword());
    }
}