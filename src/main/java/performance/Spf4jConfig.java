package performance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.perf.MeasurementRecorder;
import org.spf4j.perf.MeasurementRecorderSource;
import org.spf4j.perf.impl.RecorderFactory;

import java.io.File;

public class Spf4jConfig {

    private final static Logger logger = LoggerFactory.getLogger(Spf4jConfig.class);

    public static void initialize() {
        String tsDbFile = System.getProperty("user.dir") + File.separator + "spf4j-performance-monitoring.tsdb2";
        String tsTextFile = System.getProperty("user.dir") + File.separator + "spf4j-performance-monitoring.txt";
        logger.info("\nTime Series DB (TSDB) : {}\nTime Series text file : {}", tsDbFile, tsTextFile);
        System.setProperty("spf4j.perf.ms.config", "TSDB@" + tsDbFile);//+ "," + "TSDB_TXT@" + tsTextFile);
    }


    //Create other MeasurementRecorders if we want other settings.
    public static MeasurementRecorder getMeasurementRecorder(Object forWhat) {
        String unitOfMeasurement = "ms";
        int sampleTimeMillis = 1000;
        int factor = 10;
        int lowerMagnitude = 0;
        int higherMagnitude = 4;
        int quantasPerMagnitude = 10;

        return RecorderFactory.createScalableQuantizedRecorder(
                forWhat, unitOfMeasurement, sampleTimeMillis, factor, lowerMagnitude,
                higherMagnitude, quantasPerMagnitude);
    }
}