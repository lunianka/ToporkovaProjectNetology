package ru.netology.toporkova.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.toporkova.domain.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void saveOperation(Operation operation) {
        List<Operation> operations = storage.computeIfAbsent(operation.getId(), k -> new ArrayList<>());
        operations.add(operation);
    }

    public String getOperations() {
        return storage.toString();
    }

    public List<Operation> getOperationOnId(int operationId) {
        return storage.getOrDefault(operationId, new ArrayList<>());
    }

    public void removeOperationsOnCustomerId(int id) {
        storage.remove(id);
    }
}