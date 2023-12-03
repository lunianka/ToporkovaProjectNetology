package ru.netology.toporkova.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.toporkova.configuration.OperationProperties;
import ru.netology.toporkova.domain.Operation;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;
@Component
@RequiredArgsConstructor
public class AsyncInputOperationsService {
    private final Queue<Operation> operations = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProperties operationProcessingProperties;

    @PostConstruct
    public void startProcessing() {
        new Thread(this::processQueue).start();
    }

    public boolean addOperation(Operation operation) {
        System.out.println("Operation added for processing" + operation);
        return operations.offer(operation);
    }

    private void processQueue() {
        while (true) {
            Operation operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(operationProcessingProperties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Processing operation" + operation);
                statementService.saveOperation(operation);
            }
        }
    }
}
