package performance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.perf.MeasurementRecorder;

import java.math.BigInteger;
import java.util.Random;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    private static boolean isPrimeNumber(long number) {
        for (long i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static void slowMethod(){
        new BigInteger(2000, 9, new Random());
    }

    //View Results: java -jar target/dependency-jars/spf4j-ui-8.6.10.jar
    public static void main(String[] args) {
        Spf4jConfig.initialize();
        MeasurementRecorder measurementRecorder = Spf4jConfig
                .getMeasurementRecorder(App.class + " isPrimeNumber");
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            long numberToCheck = random.nextInt(999_999_999 - 100_000_000 + 1) + 100_000_000;
            long startTime = System.currentTimeMillis();
            boolean isPrime = isPrimeNumber(numberToCheck);
            measurementRecorder.record(System.currentTimeMillis() - startTime);
            logger.info("{}. {} is prime? {}", i + 1, numberToCheck, isPrime);
          //  slowMethod();
        }
    }
}
