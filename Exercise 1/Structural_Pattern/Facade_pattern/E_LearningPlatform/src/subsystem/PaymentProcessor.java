// file: subsystem/PaymentProcessor.java
package subsystem;

import util.LoggerUtil;

public class PaymentProcessor {

    public void processPayment(String studentName, double amount) {
        LoggerUtil.logInfo("Processing payment of $" + amount + " for " + studentName);
        // Simulated payment logic
    }
}
