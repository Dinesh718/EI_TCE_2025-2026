package adapter;

import exception.PaymentException;
import util.LoggerUtil;

public class PaymentAdapter implements PaymentGateway {
    private final LegacyPaymentService legacyService;

    public PaymentAdapter(LegacyPaymentService service) {
        this.legacyService = service;
    }

    @Override
    public boolean refund(String transactionId, double amount) throws PaymentException {
        if (transactionId == null || transactionId.isEmpty()) {
            throw new PaymentException("Transaction ID cannot be null or empty");
        }
        if (amount <= 0) {
            throw new PaymentException("Refund amount must be positive");
        }

        try {
            LoggerUtil.logInfo("Attempting refund via adapter...");
            boolean result = legacyService.legacyRefund(transactionId, amount);
            if (!result) {
                throw new PaymentException("Refund failed in legacy system");
            }
            LoggerUtil.logInfo("Refund successful for Txn: " + transactionId);
            return true;
        } catch (Exception e) {
            LoggerUtil.logError("Error during refund: " + e.getMessage());
            throw new PaymentException("Adapter refund failed", e);
        }
    }
}
