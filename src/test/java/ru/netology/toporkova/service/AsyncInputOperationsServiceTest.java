package ru.netology.toporkova.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.configuration.OperationProperties;
import ru.netology.toporkova.domain.Currency;
import ru.netology.toporkova.domain.Operation;

import static org.junit.jupiter.api.Assertions.*;

public class AsyncInputOperationsServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private AsyncInputOperationsService asyncInputOperationService;
    @Autowired
    private StatementService statementService;
    @Autowired
    private OperationProperties properties;

    @Test
    public void asyncInputOperationServiceWorksTest() throws InterruptedException {
        Operation operation = new Operation(5, 6, 100, Currency.USD, "Restaurant");

        asyncInputOperationService.offerOperation(operation);
        Thread.sleep(3L * properties.getSleepMilliSeconds());

        Operation operationOfService = statementService.getOperation(operation.getCustomerId(), 0);

        assertEquals(operation, operationOfService);
        assertEquals(operation.getId(), operationOfService.getId());
        assertEquals(operation.getSum(), operationOfService.getSum());
        assertEquals(operation.getCurrency(), operationOfService.getCurrency());
        assertEquals(operation.getMerchant(), operationOfService.getMerchant());
    }
}