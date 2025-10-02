import adapter.LegacyPaymentService;
import adapter.PaymentAdapter;
import adapter.RefundProcessor;

public class Main {
    public static void main(String[] args) {
        LegacyPaymentService legacyService = new LegacyPaymentService();
        PaymentAdapter adapter = new PaymentAdapter(legacyService);
        RefundProcessor processor = new RefundProcessor(adapter);

        processor.start();
    }
}
