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
        OperationDto operations = new OperationDto(2, 2,1500, Currency.RUB, "Rr");
        assertEquals(1500, operations.getSum());
        assertEquals("Rr", operations.getMerchant());
        assertEquals(2, operations.getCustomerId());
        assertEquals(2, operations.getId());
        assertEquals(Currency.RUB, operations.getCurrency());
    }

    @Test
    public void addOperationTest() {
        Operation operation = new Operation(1, 1,1000, Currency.RUB, "Shoko");
        asyncInputOperationService.addOperation(operation);
        Queue<Operation> operations = asyncInputOperationService.getOperations();
        assertEquals("[Operation(id=1, customerId=1, sum=1000, currency=RUB, merchant=Shoko)]", operations.toString());
    }

    @Test
    public void removeOperationTest(){
        Operation operation = new Operation(1, 1,1000, Currency.RUB, "Shoko");
        asyncInputOperationService.addOperation(operation);
        int i = asyncInputOperationService.getOperations().size();
        int operationId = 0;
        OperationController.deleteOperation(operationId);
        int y = asyncInputOperationService.getOperations().size();
        assertEquals(i, y);
    }
}