package strategy;

import exception.AppException;
import util.LoggerUtil;

import java.util.logging.Logger;

public class UPIPayment implements PaymentStrategy {
    private static final Logger LOGGER = LoggerUtil.getLogger();
    private final String upiId;

    public UPIPayment(String upiId) {
        if (upiId == null || upiId.trim().isEmpty())
            throw new IllegalArgumentException("UPI ID cannot be empty");
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) throws AppException {
        if (amount <= 0) throw new AppException("Amount must be positive");
        LOGGER.info(() -> String.format("Paid %.2f using UPI [%s]", amount, upiId));
    }
}
