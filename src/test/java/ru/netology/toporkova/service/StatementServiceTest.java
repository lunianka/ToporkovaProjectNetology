package ru.netology.toporkova.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.domain.Currency;
import ru.netology.toporkova.domain.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private StatementService statementService;

    @Test
    public void saveOperationInStatementServiceTest() {
        int customerId = 3;

        Operation operation = new Operation(4, customerId, 1900, Currency.RUB, "Cafe");
        statementService.setOperation(customerId, operation);
        Operation operationOfService = statementService.getOperation(customerId, 0);

        assertEquals(operation, operationOfService);
        assertEquals(4, operationOfService.getId());
        assertEquals(1900, operationOfService.getSum());
        assertEquals(Currency.RUB, operationOfService.getCurrency());
        assertEquals("Cafe", operationOfService.getMerchant());
        assertEquals(customerId, operationOfService.getCustomerId());
    }
    @Test
    public void removeOperationTest(){
        int customerId = 7;
        int operationId = 6;
        Operation operation = new Operation(operationId, customerId, 3000, Currency.RUB, "Cafe");
        statementService.setOperation(customerId, operation);
        statementService.removeOperation(customerId, operationId);
        assertEquals("[]", statementService.getOperationsForCustomers(customerId));
    }
}
