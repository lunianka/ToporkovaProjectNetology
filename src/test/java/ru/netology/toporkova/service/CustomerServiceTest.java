package ru.netology.toporkova.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.domain.Customer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest extends OperationHistoryApiApplicationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void getCustomersTest() {
        assertEquals(new Customer(1, "Spring"), customerService.getCustomer(0));
        assertEquals(new Customer(2, "Boot"), customerService.getCustomer(1));
    }

    @Test
    public void addCustomerTest(){
        customerService.addCustomer(3,"Kate");
        List<Customer> customers = customerService.getCustomers();
        Customer customer = customerService.getCustomer(customers.size()-1);
        assertEquals("Kate", customer.getName());
    }
}