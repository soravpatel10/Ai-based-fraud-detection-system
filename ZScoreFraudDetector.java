package ai;

import model.Transaction;
import java.util.List;

public class ZScoreFraudDetector extends FraudDetectorBase implements FraudDetector {

    @Override
    public boolean analyze(Transaction t, List<Transaction> history) throws Exception {

        introMessage();

        double sum = 0;
        for(Transaction tx : history){
            sum += tx.getAmount();
        }

        double mean = sum / history.size();
        double variance = 0;

        for(Transaction tx : history){
            variance += Math.pow(tx.getAmount() - mean, 2);
        }

        double stdDev = Math.sqrt(variance / history.size());
        double zScore = (t.getAmount() - mean) / stdDev;

        return Math.abs(zScore) > 2.5;
    }
}
