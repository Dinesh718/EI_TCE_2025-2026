package adapter;

public class LegacyPaymentService {
    public boolean legacyRefund(String txnId, double amt) {
        // Simulate a refund
        System.out.println("Legacy refund processed for Txn: " + txnId + " Amount: " + amt);
        return true; // true if success
    }
}
