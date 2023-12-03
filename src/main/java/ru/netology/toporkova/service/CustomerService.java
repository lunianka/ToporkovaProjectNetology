package ru.netology.toporkova.service;

import ru.netology.toporkova.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage;

    public List<Customer> getCustomers() {
        return storage;
    }

    public Customer getCustomer(int customerId) {
        return storage.get(customerId);
    }

    public void addCustomer(int id, String name){
        storage.add(new Customer(name, id));
    }

    @PostConstruct
    public void init(){
        storage.add(new Customer("Spring",1));
        storage.add(new Customer("Boot",2));
        storage.add(new Customer("Vlad", 3));
        storage.remove(1);



    }
}