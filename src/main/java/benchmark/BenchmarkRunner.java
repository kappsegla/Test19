package benchmark;

import lcs.LongestCommonSubsequence;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
//https://www.baeldung.com/java-microbenchmark-harness

public class BenchmarkRunner {
//    @Fork(value = 3, warmups = 2) means that 5 forks will be run sequentially. The first two will be warmup runs which will be ignored, and the final 3 will be used for benchmarking.
//    @Warmup(iterations = 5, time = 55, timeUnit = TimeUnit.MILLISECONDS) means that there will be 5 warmup iterations within each fork. The timings from these runs will be ignored when producing the benchmark results.
//    @Measurement(iterations = 4, time = 44, timeUnit = TimeUnit.MILLISECONDS) means that your benchmark iterations will be run 4 times (after the 5 warmup iterations).

    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void init(ExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            plan.lcs.longestCommonSubsequence(plan.s1, plan.s2);
        }
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
