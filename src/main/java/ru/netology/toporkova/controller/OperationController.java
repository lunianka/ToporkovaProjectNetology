package ru.netology.toporkova.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.toporkova.service.AsyncInputOperationsService;
import ru.netology.toporkova.controller.dto.OperationsDTO;
import ru.netology.toporkova.controller.dto.OperationsGetResponse;
import ru.netology.toporkova.domain.Operation;
import ru.netology.toporkova.service.StatementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/operations")
@RequiredArgsConstructor
public class OperationController {
    private final AsyncInputOperationsService asyncInputOperationService;
    private final StatementService statementService;

//    @PostMapping
//    public Operation postOperation(@RequestBody Operation operation) {
//        asyncInputOperationService.addOperation(operation);
//        return operation;
//    }
    @GetMapping("{customerId}")
    public List<OperationsDTO> getOperations(@PathVariable Integer customerId) {
        List<Operation> operations = statementService.getOperations(customerId);
        return operations.stream()
            .map(o -> new OperationsDto(o.getId(),o.getCustomerId(),o.getSum(),o.getCurrency(),o.getMerchant()))
            .collect(Collectors.toList());
}

    @GetMapping("/{customerId}")
    public ResponseEntity<Iterable<Operation>> getClientOperations(@PathVariable Integer customerId) {
        List<Operation> operations = statementService.getCustomerOperations(customerId);
        if (operations == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable Integer id) {
        for (List<Operation> operations : statementService.getStatement().values())
            for (Operation operation : operations)
                if (operation.getId().equals(id))
                    return new ResponseEntity<>(operation, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}