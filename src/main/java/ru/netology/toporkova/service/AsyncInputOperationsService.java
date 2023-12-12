package ru.netology.toporkova.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.toporkova.configuration.OperationProperties;
import ru.netology.toporkova.domain.Currency;
import ru.netology.toporkova.domain.Operation;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;
@Service
@RequiredArgsConstructor
public class AsyncInputOperationsService {
    private final Queue<Operation> queue = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProperties properties;

    public boolean offerOperation(Operation operation) {
        return queue.offer(operation);
    }

    public Queue<Operation> getOperations(){
        return queue;
    }



    public void addOperation(int id, int customerId, double sum, Currency currency,
                             String merchant){
        Operation operation = new Operation();
        queue.add(operation);
    }

    public boolean addOperation(Operation operation){
        System.out.println("Operation added for processing " + operation);
        return queue.offer(operation);
    }

    @PostConstruct
    private void postInit() {
        this.startAsyncOperationProcessing();
    }

    private void startAsyncOperationProcessing() {
        new Thread(this::processQueue).start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();

            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(properties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation:" + operation);

                statementService.setOperation(operation.getCustomerId(), operation);
            }
        }
    }
}
