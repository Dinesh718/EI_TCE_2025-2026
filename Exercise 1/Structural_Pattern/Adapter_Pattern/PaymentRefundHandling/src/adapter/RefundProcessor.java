package adapter;

import exception.PaymentException;
import util.LoggerUtil;

import java.util.Scanner;

public class RefundProcessor {
    private final PaymentGateway paymentGateway;
    private final Scanner scanner;

    public RefundProcessor(PaymentGateway gateway) {
        this.paymentGateway = gateway;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        LoggerUtil.logInfo("Payment Refund System Started");
        boolean running = true;

        while (running) {
            System.out.println("\n--- Payment Refund Menu ---");
            System.out.println("1) Refund Payment");
            System.out.println("2) Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    processRefund();
                    break;
                case "2":
                    running = false;
                    LoggerUtil.logInfo("Exiting Payment Refund System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void processRefund() {
        try {
            System.out.print("Enter Transaction ID: ");
            String txnId = scanner.nextLine();

            System.out.print("Enter Refund Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            boolean success = paymentGateway.refund(txnId, amount);
            if (success) {
                System.out.println("Refund processed successfully.");
            } else {
                System.out.println("Refund failed.");
            }
        } catch (PaymentException e) {
            LoggerUtil.logError("PaymentException: " + e.getMessage());
        } catch (NumberFormatException e) {
            LoggerUtil.logError("Invalid amount entered. Must be a number.");
        } catch (Exception e) {
            LoggerUtil.logError("Unexpected error: " + e.getMessage());
        }
    }
}
