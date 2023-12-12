package ru.netology.toporkova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.toporkova.controller.dto.OperationDto;
import ru.netology.toporkova.domain.Operation;
import ru.netology.toporkova.service.AsyncInputOperationsService;
import ru.netology.toporkova.service.StatementService;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
@RequiredArgsConstructor
public class OperationController {

    private final AsyncInputOperationsService asyncInputOperationService;
    private static final StatementService statementService = new StatementService();


    @PostMapping
    public Operation postOperation(@RequestBody Operation operation) {
        asyncInputOperationService.offerOperation(operation);
        return operation;
    }


    @GetMapping("/{customerId}")
    public OperationDto getOperation(@PathVariable int customerId) {
        for (Operation operation : asyncInputOperationService.getOperations()) {
            if (operation.getCustomerId() == customerId) {
                OperationDto operationsDTO = new OperationDto(operation.getId(), operation.getCustomerId(),
                        operation.getSum(), operation.getCurrency(), operation.getMerchant());
                return operationsDTO;
            }
        }
        return null;
    }

    @PostMapping("/{customerId}")
    public void addOperation(@RequestBody Operation operation) {
        asyncInputOperationService.addOperation(operation.getId(), operation.getCustomerId(),
                operation.getSum(), operation.getCurrency(), operation.getMerchant());
    }

    public static Operation deleteOperation(Integer id) {
        for (List<Operation> operations : statementService.getStatement().values())
            for (Operation operation : operations)
                if (operation.getId().equals(id))
                    return operation;
        return null;
    }

}
