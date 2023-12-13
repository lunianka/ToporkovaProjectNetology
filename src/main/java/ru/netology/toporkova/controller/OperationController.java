package ru.netology.toporkova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.toporkova.controller.dto.OperationDto;
import ru.netology.toporkova.controller.dto.OperationsGetResponse;
import ru.netology.toporkova.domain.Operation;
import ru.netology.toporkova.service.AsyncInputOperationsService;
import ru.netology.toporkova.service.StatementService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    @GetMapping
    public OperationsGetResponse getInputOperations() {
        Queue<Operation> operations = asyncInputOperationService.getOperations();
        List<OperationDto> operationDTOS = new ArrayList<>();
        for (Operation operation : operations) {
            OperationDto operationDTO = new OperationDto(operation.getId(), operation.getCustomerId(),
                    operation.getSum(), operation.getCurrency(),operation.getMerchant());
            operationDTOS.add(operationDTO);
        }
        return new OperationsGetResponse(operationDTOS);
    }

    @GetMapping("/{customerId}")
    public OperationDto getOperation(@PathVariable int customerId) {
        for (Operation operation : asyncInputOperationService.getOperations()) {
            if (operation.getCustomerId() == customerId) {
                return new OperationDto(operation.getId(), operation.getCustomerId(),
                        operation.getSum(), operation.getCurrency(), operation.getMerchant());
            }
        }
        return null;
    }

    @PostMapping("/{customerId}")
    public void addOperation(@RequestBody Operation operation) {
        asyncInputOperationService.addOperation(operation.getId(), operation.getCustomerId(),
                operation.getSum(), operation.getCurrency(), operation.getMerchant());
    }

    @DeleteMapping("remove")
    public static void removeOperation(@RequestParam int customerId, @RequestParam int operationId) {
        statementService.removeOperation(customerId,operationId);
    }

}
