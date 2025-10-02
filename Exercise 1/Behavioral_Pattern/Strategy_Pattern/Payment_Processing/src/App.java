

import model.*;
import strategy.*;
import exception.AppException;
import util.LoggerUtil;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n=== E-Commerce Menu ===");
                System.out.println("1. Add Item to Cart");
                System.out.println("2. Checkout & Pay");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter item price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        cart.addItem(new Item(name, price));
                        LOGGER.info(() -> "Item added to cart: " + name + " - " + price);
                    }
                    case 2 -> {
                        if (cart.isEmpty()) {
                            LOGGER.warning("Cart is empty. Add items first.");
                            break;
                        }
                        System.out.println("Choose payment method:");
                        System.out.println("1. Credit Card");
                        System.out.println("2. UPI");
                        System.out.println("3. PayPal");
                        System.out.print("Enter choice: ");
                        int paymentChoice = Integer.parseInt(scanner.nextLine().trim());
                        PaymentStrategy strategy = switch (paymentChoice) {
                            case 1 -> {
                                System.out.print("Enter card number: ");
                                String cardNumber = scanner.nextLine();
                                System.out.print("Enter card holder name: ");
                                String cardHolder = scanner.nextLine();
                                yield new CreditCardPayment(cardNumber, cardHolder);
                            }
                            case 2 -> {
                                System.out.print("Enter UPI ID: ");
                                String upiId = scanner.nextLine();
                                yield new UPIPayment(upiId);
                            }
                            case 3 -> {
                                System.out.print("Enter PayPal email: ");
                                String email = scanner.nextLine();
                                yield new PayPalPayment(email);
                            }
                            default -> null;
                        };
                        if (strategy != null) {
                            paymentProcessor.setPaymentStrategy(strategy);
                            paymentProcessor.processPayment(cart.calculateTotal());
                            LOGGER.info("Payment successful. Thank you!");
                        } else {
                            LOGGER.warning("Invalid payment choice");
                        }
                    }
                    case 3 -> {
                        LOGGER.info("Exiting application...");
                        exit = true;
                    }
                    default -> LOGGER.warning("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                LOGGER.severe("Invalid input. Enter numeric value only.");
            } catch (AppException e) {
                LOGGER.severe("Payment error: " + e.getMessage());
            } catch (Exception e) {
                LOGGER.severe("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
