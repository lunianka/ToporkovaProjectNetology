package ru.netology.toporkova.service;

import org.springframework.stereotype.Service;
import ru.netology.toporkova.domain.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public List<Customer> getCustomers() {
        return storage;
    }

    public Customer getCustomer(int index) {
        return storage.get(index);
    }

    public void addCustomer(Customer customer) {
        storage.add(customer);
    }

    @PostConstruct
    public void initStorage() {
        addCustomer(new Customer(1, "Spring", "pass"));
        addCustomer(new Customer(2, "Boot", "pass"));
    }
}