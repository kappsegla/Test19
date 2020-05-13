package lcs;


import java.time.Year;

//https://www.youtube.com/watch?v=DuikFLPt8WQ
//https://www.ics.uci.edu/~eppstein/161/960229.html
public class LCS {

    public static void main(String[] args) {

        String s1 =  "JAVAAID";
        String s2 = "JAVAID";

        char[] A = "JAVAAID".toCharArray();
        char[] B = "JAVAID".toCharArray();

        int i = A.length - 1;
        int j = B.length - 1;

        //int length = LCSM1(A, B, i, j);
        //System.out.println(length);
        //   System.out.println(time(() -> LCSM1(A, B, i, j)));

        int[][] DP = new int[i + 1][j + 1];
        //System.out.println(time(() -> LCSM2(A, B, i, j, DP)));
     //   LCSM2(A, B, i, j, DP);
     //   diff(A, B, i + 1, j + 1, DP);
    LCSLength(s1,s2,i,j,DP);
    diff(s1,s2,s1.length(),s2.length(),DP);


//        System.out.println(time(() -> LCSM3(A, B, i, j)));
//        System.out.println(time(() -> LCSM4(A, B, i, j)));


//        length = LCSM2(A, B, i, j, DP);
//        System.out.println(length);
//
//        length = LCSM3(A, B, i, j);
//        System.out.println(length);
//
//        length = LCSM4(A, B, i, j);
//        System.out.println(length);

    }

    static long time(Runnable runnable) {
        long start = 0;
        long end = 0;

        start = System.nanoTime();

        runnable.run();

        end = System.nanoTime();
        return end - start;
    }


    //Recursive solution
    static int LCSM1(char[] X, char[] Y, int i, int j) {

        if (i <= 0 || j <= 0)
            return 0;

        //Case 1 when characters matches
        if (X[i] == Y[j])
            return 1 + LCSM1(X, Y, i - 1, j - 1);
        else
            //Case 2 when characters doesn't match
            return Math.max(LCSM1(X, Y, i, j - 1), LCSM1(X, Y, i - 1, j));
    }

    //Top down approach with memoization
    static int LCSM2(char[] X, char[] Y, int i, int j, int[][] dp) {

        if (i <= 0 || j <= 0)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        //Case 1 when characters matches
        if (X[i] == Y[j])
            return 1 + LCSM2(X, Y, i - 1, j - 1, dp);
        else
            //Case 2 when characters doesn't match
            return dp[i][j] = Math.max(LCSM2(X, Y, i, j - 1, dp), LCSM2(X, Y, i - 1, j, dp));
    }

    //DP Bottom up approach
    //Time complexity: O(m*n), Space complexity: O(m*n)
    static int LCSM3(char[] X, char[] Y, int m, int n) {

        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1])
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }

        return memo[m][n];
    }

    //DP Bottom up, efficent solution
    //Time complexity: O(m*n), Space complexity: O(n)
    static int LCSM4(char[] X, char[] Y, int m, int n) {

        int[] memo = new int[n + 1];


        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];

                if (X[i - 1] == Y[j - 1])
                    memo[j] = prev + 1;
                else
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                prev = temp;
            }
        }

        return memo[n];
    }

    // Function to display the differences between two Strings
    public static void diff(String X, String Y, int m, int n, int[][] lookup) {
        // if last character of X and Y matches
        if (m > 0 && n > 0 && X.charAt(m - 1) == Y.charAt(n - 1)) {
            diff(X, Y, m - 1, n - 1, lookup);
            System.out.print("  " + X.charAt(m - 1));
        }

        // current character of Y is not present in X
        else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n])) {
            diff(X, Y, m, n - 1, lookup);
            System.out.print(" +" + Y.charAt(n - 1));
        }

        // current character of X is not present in Y
        else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n])) {
            diff(X, Y, m - 1, n, lookup);
            System.out.print(" -" + X.charAt(m - 1));
        }
    }

    // Function to fill lookup table by finding the length of LCS
    // of substring X[0..m-1] and Y[0..n-1]
    public static void LCSLength(String X, String Y, int m, int n,
                                 int[][] lookup) {
        // first column of the lookup table will be all 0
        for (int i = 0; i <= m; i++) {
            lookup[i][0] = 0;
        }

        // first row of the lookup table will be all 0
        for (int j = 0; j <= n; j++) {
            lookup[0][j] = 0;
        }

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j],
                            lookup[i][j - 1]);
                }
            }
        }
    }
}