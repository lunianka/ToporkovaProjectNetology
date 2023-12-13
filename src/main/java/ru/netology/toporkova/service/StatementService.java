package ru.netology.toporkova.service;

import org.springframework.stereotype.Service;
import ru.netology.toporkova.domain.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public Map<Integer, List<Operation>> getStatement() {
        return storage;
    }

    public List<Operation> getCustomerOperations(int customerId) {
        return storage.containsKey(customerId) ? storage.getOrDefault(customerId, List.of()) : null;
    }

    public Operation getOperation(int customerId, int operationIndex) {
        return storage.get(customerId).get(operationIndex);
    }

    public String getOperationsForCustomers(int customerId) {
        return storage.get(customerId).toString();
    }

    public String getOperations(){
        return storage.toString();
    }

    public void setOperation(int customerId, Operation operation) {
        List<Operation> operations = storage.get(customerId);

        if (operations == null) {
            operations = new ArrayList<>();
        }

        operations.add(operation);

        storage.put(customerId, operations);
    }

    public void removeOperation(int customerId, int operationId){
        List<Operation> operations = storage.get(customerId);
        if (operations == null)
            return;

        operations.removeIf(o -> o.getId() == operationId);
    }
}