package ru.netology.toporkova.service;

import org.springframework.stereotype.Service;
@Service
public class OperationsService {
    public ClientService clientService;
    public AccountService accountService;

    public OperationsService(ClientService clientService, AccountService accountService) {
        this.clientService = clientService;
        this.accountService = accountService;
    }

    public void print(){
        System.out.println("Client: " + clientService.getClient());
        System.out.println("Accounts: " + accountService.getAccounts());
    }
}
