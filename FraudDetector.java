package ai;

import model.Transaction;
import java.util.List;

public interface FraudDetector {
    boolean analyze(Transaction t, List<Transaction> history) throws Exception;
}
