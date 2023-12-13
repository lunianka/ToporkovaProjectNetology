package ru.netology.toporkova.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.toporkova.OperationHistoryApiApplicationTest;
import ru.netology.toporkova.controller.dto.OperationDto;
import ru.netology.toporkova.domain.Currency;
import ru.netology.toporkova.domain.Operation;
import ru.netology.toporkova.service.AsyncInputOperationsService;

import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationControllerTest extends OperationHistoryApiApplicationTest {

    @Autowired
    private AsyncInputOperationsService asyncInputOperationService;

    @Test
    public void getOperationTest() {
        int operationId = 2;
        int customerId = 1;
        OperationDto operations = new OperationDto(operationId, customerId,3000, Currency.RUB, "Bar");
        assertEquals(operationId, operations.getId());
        assertEquals(customerId, operations.getCustomerId());
        assertEquals(3000, operations.getSum());
        assertEquals(Currency.RUB, operations.getCurrency());
        assertEquals("Bar", operations.getMerchant());
    }

    @Test
    public void addOperationTest() {
        Operation operation = new Operation(1, 1,1000, Currency.RUB, "Pharmacy");
        asyncInputOperationService.addOperation(operation);
        Queue<Operation> operations = asyncInputOperationService.getOperations();
        assertEquals("[Operation(id=1, customerId=1, sum=1000, currency=RUB, merchant=Pharmacy)]", operations.toString());
    }

    @Test
    public void removeOperationTest(){
        int operationId = 2;
        int customerId = 2;
        Operation operation = new Operation(operationId, customerId,1500, Currency.RUB, "Theatre");
        asyncInputOperationService.addOperation(operation);
        int i = asyncInputOperationService.getOperations().size();
        OperationController.removeOperation(operationId, customerId);
        int y = asyncInputOperationService.getOperations().size();
        assertEquals(i, y);
    }
}