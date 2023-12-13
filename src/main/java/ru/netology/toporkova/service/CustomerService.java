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

    public void addCustomer(int id, String name) {
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }

    public void removeCustomer(int id) {
        storage.removeIf(c -> c.getId() == id);
    }

    @PostConstruct
    public void initStorage() {
        storage.add(new Customer(1, "Spring"));
        storage.add(new Customer(2, "Boot"));
    }
}