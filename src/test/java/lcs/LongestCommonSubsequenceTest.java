package lcs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonSubsequenceTest {

    final static LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @ParameterizedTest
    @MethodSource("stringStringAndSetProvider")
    void testWithMultiArgMethodSource(String a, String b, Set<String> set) {
        Set<String> expectedSet = Set.of("BCAB", "BCBA", "BDAB");

        Set<String> actual = lcs.lcs("ABCBDAB", "BDCABA");
        assertEquals(expectedSet, actual);
    }

    @ParameterizedTest
    @MethodSource("stringStringAndSetProvider")
    void testForLongestCommonSubsequence(String a, String b, Set<String> set) {
        Set<String> expectedSet = Set.of("BCAB", "BCBA", "BDAB");

        Set<String> actual = lcs.longestCommonSubsequence("ABCBDAB", "BDCABA");
        assertEquals(expectedSet, actual);
    }



    static Stream<Arguments> stringStringAndSetProvider() {
        return Stream.of(
                arguments("ABCBDAB", "BDCABA", Set.of("BCAB", "BCBA", "BDAB")),
                arguments("AGTGATG", "GTTAG", Set.of("GTTG", "GTAG")),
                arguments("ABC", "AC", Set.of("AC")),
                arguments("ABCDGH", "AEDFHR", Set.of("ADH"))
        );
    }
}