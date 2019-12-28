package benchmark;

import lcs.LongestCommonSubsequence;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({"10", "20", "30", "50", "100"})
    public int iterations;

    public LongestCommonSubsequence lcs;
    public String s1 = "hdsfaafdfsdfdadfadadsfk";
    public String s2 = "sdfjdsjkldsjkldjksfljkldsfjkldsjkldsjkldsjkl";

    @Setup(Level.Invocation)
    public void setUp() {
        lcs = new LongestCommonSubsequence();
    }
}
