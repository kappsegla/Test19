package lcs;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("bobtheabb"));
    }

    int resultStart;
    int restultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2)
            return s;
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + restultLength);

    }

    private void expandRange(String str, int begin, int end) {
        while( begin >= 0 && end < str.length() &&
        str.charAt(begin) == str.charAt(end)){
            begin--;
            end++;
        }
        if( restultLength < end - begin - 1){
            resultStart = begin+1;
            restultLength = end - begin -1;
        }
    }
}
