package lcs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubsequence {

    // Maximum String length
    static int N = 100;
    static int[][] L = new int[N][N];

    public Set<String> lcs(String a, String b) {
        int m = a.length();
        int n = b.length();

        System.out.println("LCS length is " +
                LCS(a, b, m, n));

        Set<String> s = findLCS(a, b, m, n);
        return s;
    }

    /* Returns set containing all LCS for
   X[0..m-1], Y[0..n-1] */
    Set<String> findLCS(String X, String Y, int m, int n) {
        // construct a set to store possible LCS
        Set<String> s = new HashSet<>();

        // If we reaches end of either String,
        // return a empty set
        if (m == 0 || n == 0) {
            s.add("");
            return s;
        }

        // If the last characters of X and Y are same
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            // recurse for X[0..m-2] and Y[0..n-2]
            // in the matrix
            Set<String> tmp = findLCS(X, Y, m - 1, n - 1);

            // append current character to all possible LCS
            // of subString X[0..m-2] and Y[0..n-2].
            for (String str : tmp)
                s.add(str + X.charAt(m - 1));
        }

        // If the last characters of X and Y are not same
        else {
            // If LCS can be constructed from top side of
            // the matrix, recurse for X[0..m-2] and Y[0..n-1]
            if (L[m - 1][n] >= L[m][n - 1])
                s = findLCS(X, Y, m - 1, n);

            // If LCS can be constructed from left side of
            // the matrix, recurse for X[0..m-1] and Y[0..n-2]
            if (L[m][n - 1] >= L[m - 1][n]) {
                Set<String> tmp = findLCS(X, Y, m, n - 1);

                // merge two sets if L[m-1][n] == L[m][n-1]
                // Note s will be empty if L[m-1][n] != L[m][n-1]
                s.addAll(tmp);
            }
        }
        return s;
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int LCS(String X, String Y, int m, int n) {
        // Build L[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }
        return L[m][n];
    }

   // private Set<String> longestCommonSubsequenceList;
    private static final String INSERT_COLOR = "#99FFCC";
    private static final String DELETE_COLOR = "#CB6D6D";

//    public LongestCommonSubsequence(String text1, String text2) {
//
//        text1 = normalizeText(text1);
//        text2 = normalizeText(text2);
//        this.longestCommonSubsequenceList = longestCommonSubsequence(text1, text2);
//        String result = markTextDifferences(text1, text2,
//                longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
//    }

    /**
     * Finds a list of longest common subsequences (lcs) of given two texts.
     *
     * @param text1
     * @param text2
     * @return - longest common subsequence list
     */
    public Set<String> longestCommonSubsequence(String text1, String text2) {
        String[] text1Words = text1.split(" ");
        String[] text2Words = text2.split(" ");
        int text1WordCount = text1Words.length;
        int text2WordCount = text2Words.length;

        int[][] solutionMatrix = new int[text1WordCount + 1][text2WordCount + 1];

        for (int i = text1WordCount - 1; i >= 0; i--) {
            for (int j = text2WordCount - 1; j >= 0; j--) {
                if (text1Words[i].equals(text2Words[j])) {
                    solutionMatrix[i][j] = solutionMatrix[i + 1][j + 1] + 1;
                } else {
                    solutionMatrix[i][j] = Math.max(solutionMatrix[i + 1][j],
                            solutionMatrix[i][j + 1]);
                }
            }
        }

        int i = 0, j = 0;
        Set<String> lcsResultList = new HashSet<>();
        while (i < text1WordCount && j < text2WordCount) {
            if (text1Words[i].equals(text2Words[j])) {
                lcsResultList.add(text2Words[j]);
                i++;
                j++;
            } else if (solutionMatrix[i + 1][j] >= solutionMatrix[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return lcsResultList;
    }

//    /**
//     * Normalizes given string by deleting \n, \t and extra spaces.
//     *
//     * @param text - initial string
//     * @return - normalized string
//     */
//    private String normalizeText(String text) {
//
//        text = text.trim();
//        text = text.replace("\n", " ");
//        text = text.replace("\t", " ");
//
//        while (text.contains("  ")) {
//            text = text.replace("  ", " ");
//        }
//        return text;
//    }

//    /**
//     * Returns colored inserted/deleted text representation of given two texts.
//     * Uses longestCommonSubsequenceList to determine colored sections.
//     *
//     * @param text1
//     * @param text2
//     * @param lcsList
//     * @param insertColor
//     * @param deleteColor
//     * @return - colored result text
//     */
//    private String markTextDifferences(String text1, String text2,
//                                       Set<String> lcsList, String insertColor, String deleteColor) {
//        StringBuffer stringBuffer = new StringBuffer();
//        if (text1 != null && lcsList != null) {
//            String[] text1Words = text1.split(" ");
//            String[] text2Words = text2.split(" ");
//            int i = 0, j = 0, word1LastIndex = 0, word2LastIndex = 0;
//            for (int k = 0; k < lcsList.size(); k++) {
//                for (i = word1LastIndex, j = word2LastIndex;
//                     i < text1Words.length && j < text2Words.length; ) {
//                    if (text1Words[i].equals(lcsList.get(k)) &&
//                            text2Words[j].equals(lcsList.get(k))) {
//                        stringBuffer.append("<SPAN>" + lcsList.get(k) + " </SPAN>");
//                        word1LastIndex = i + 1;
//                        word2LastIndex = j + 1;
//                        i = text1Words.length;
//                        j = text2Words.length;
//                    } else if (!text1Words[i].equals(lcsList.get(k))) {
//                        for (; i < text1Words.length &&
//                                !text1Words[i].equals(lcsList.get(k)); i++) {
//                            stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
//                                    deleteColor + "'>" + text1Words[i] + " </SPAN>");
//                        }
//                    } else if (!text2Words[j].equals(lcsList.get(k))) {
//                        for (; j < text2Words.length &&
//                                !text2Words[j].equals(lcsList.get(k)),j++){
//                            stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
//                                    insertColor + "'>" + text2Words[j] + " </SPAN>");
//                        }
//                    }
//                }
//            }
//            for (; word1LastIndex < text1Words.length; word1LastIndex++) {
//                stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
//                        deleteColor + "'>" + text1Words[word1LastIndex] + " </SPAN>");
//            }
//            for (; word2LastIndex < text2Words.length; word2LastIndex++) {
//                stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
//                        insertColor + "'>" + text2Words[word2LastIndex] + " </SPAN>");
//            }
//        }
//        return stringBuffer.toString();
//    }

}
