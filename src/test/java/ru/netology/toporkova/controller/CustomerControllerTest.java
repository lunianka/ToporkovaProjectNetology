package ru.netology.toporkova.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.controller.dto.CustomersGetResponse;
import ru.netology.toporkova.domain.Customer;
import ru.netology.toporkova.controller.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CustomerControllerTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private CustomerController customerController;

    @Test
    public void getCustomerByIdNullTest(){
        CustomerDto customerDTO = customerController.getCustomerById(10);
        assertNull(customerDTO);
    }

    @Test
    public void getCustomerByIdTest(){
        CustomerDto customerDto = customerController.getCustomerById(1);
        assertEquals(1, customerDto.getId());
        assertEquals("Spring", customerDto.getName());
    }

    @Test
    public void getCustomersTest(){
        CustomersGetResponse customers = customerController.getCustomers();
        CustomerDto customer1 = customers.getCustomers().get(0);
        CustomerDto customer2 = customers.getCustomers().get(1);

        assertEquals(1, customer1.getId());
        assertEquals("Spring", customer1.getName());
        assertEquals(2, customer2.getId());
        assertEquals("Boot", customer2.getName());
    }

    @Test
    public void addCustomerTest(){
        int customerId = 5;
        String customerName = "Anna";
        Customer customer1 = new Customer(customerId, customerName) ;
        customerController.addCustomer(customer1);
        assertEquals(customerId, customer1.getId());
        assertEquals(customerName, customer1.getName());
    }

}