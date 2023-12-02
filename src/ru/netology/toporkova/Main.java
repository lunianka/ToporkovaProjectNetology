package ru.netology.toporkova;

import ru.netology.toporkova.domain.Client;
import ru.netology.toporkova.domain.Operation;

import java.util.Scanner;

public class Main {
    public final static int MAX_OPERATIONS = 1_000;
    public final static int MAX_CLIENTS = 100;
    private final static Operation[] operations = new Operation[MAX_OPERATIONS];
    private final static Client[] clients = new Client[MAX_CLIENTS];

    private static final int[][] statement = new int[MAX_CLIENTS][MAX_OPERATIONS / MAX_CLIENTS];
    private static final int[] clientOperationsCount = new int[MAX_CLIENTS];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        inputClients(scanner);

        inputOperation(scanner);

    }

    private static void inputClients(Scanner scanner){
        int clientsCount = 0;
        while (true) {
            System.out.println("Client name: ");
            String name = scanner.nextLine();
            Client client = new Client(clientsCount, name);

            clients[clientsCount] = client;
            clientsCount++;

            System.out.println("Do you want to enter next client? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")) {
                break;
            }

            if (clientsCount == MAX_CLIENTS) {
                break;
            }
        }
    }

    private static void inputOperation(Scanner scanner){
        int operationId = 0;
        while (true) {
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            Operation operation = new Operation(operationId, sum, currency, merchant);

            operations[operationId] = operation;
            operationId++;

            System.out.println("Client: ");
            int clientId = scanner.nextInt();
            scanner.nextLine();

            int operationsCountForClient = clientOperationsCount[clientId];
            statement[clientId][operationsCountForClient] = operationId;
            clientOperationsCount[clientId]++;

            System.out.println("Do you want to enter next operation? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")){
                break;
            }

            if (operationId == MAX_OPERATIONS) {
                break;
            }
        }
    }
}

