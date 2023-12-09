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
    public void getInputOperationsTest() {
        Operation operation = new Operation(5, 300, Currency.RUB, "Restaurant", 1);
        assertEquals(5, operation.getId());
        assertEquals(300, operation.getSum());
        assertEquals(Currency.RUB, operation.getCurrency());
        assertEquals("Restaurant", operation.getMerchant());
        assertEquals(1, operation.getCustomerId());

    }
//    @Test
//    public void getOperationTest() {
//        OperationsDTO operations = new OperationsDTO(CREDIT, 1000, Currency.RUB, "Shoko", 1);
//        assertEquals(1000, operations.getSum());
//        assertEquals("Shoko", operations.getMerchant());
//        assertEquals(1, operations.getCustomerId());
//        assertEquals(CREDIT, operations.getOperationCreditType());
//        assertEquals(Currency.RUB, operations.getCurrency());
//    }
//
//    @Test
//    public void addOperationTest() {
//        Operation operation = new Operation(5, 300, Currency.RUB, "Restaurant", 1);;
//        asyncInputOperationService.addOperation(operation);
//        Queue<Operation> operations = asyncInputOperationService.getOperations();
//        assertEquals("[Транзакция №0. 1000.0 в Shoko null]", operations.toString());
//    }
//
//    @Test
//    public void removeOperationTest(){
//        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
//        asyncInputOperationService.addOperation(operation);
//        int i = asyncInputOperationService.getOperations().size();
//        int operationId = 0;
//        asyncInputOperationService.removeOperation(operationId);
//        int y = asyncInputOperationService.getOperations().size();
//        assertEquals(i, y);
//    }
}