package strategy;

import exception.AppException;
import util.LoggerUtil;

import java.util.logging.Logger;

public class CreditCardPayment implements PaymentStrategy {
    private static final Logger LOGGER = LoggerUtil.getLogger();
    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        if (cardNumber == null || cardNumber.trim().length() < 12)
            throw new IllegalArgumentException("Invalid card number");
        if (cardHolder == null || cardHolder.trim().isEmpty())
            throw new IllegalArgumentException("Card holder cannot be empty");
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) throws AppException {
        if (amount <= 0) throw new AppException("Amount must be positive");
        LOGGER.info(() -> String.format("Paid %.2f using Credit Card [%s] by %s", amount, cardNumber, cardHolder));
    }
}
