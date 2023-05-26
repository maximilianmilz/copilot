package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static Stream<Arguments> sortNumbersTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{3, 3, 3}, new int[]{3, 3, 3}),
                Arguments.of(new int[]{-5, 10, 0, -1, 7}, new int[]{-5, -1, 0, 7, 10})
        );
    }

    static Stream<Arguments> fibonacciTestCases() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(9, 34),
                Arguments.of(10, 55),
                Arguments.of(11, 89),
                Arguments.of(12, 144),
                Arguments.of(13, 233),
                Arguments.of(14, 377),
                Arguments.of(15, 610),
                Arguments.of(20, 6765),
                Arguments.of(25, 75025),
                Arguments.of(30, 832040),
                Arguments.of(35, 9227465)
        );
    }

    static Stream<Arguments> palindromeTestCases() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("a", true),
                Arguments.of("racecar", true),
                Arguments.of("deified", true),
                Arguments.of("A man a plan a canal Panama", true),
                Arguments.of("not a palindrome", false),
                Arguments.of("racecars", false),
                Arguments.of("palindrome test", false)
        );
    }

    static Stream<Arguments> gcdTestCases() {
        return Stream.of(
                Arguments.of(10, 25, 5, true),
                Arguments.of(14, 28, 14, true),
                Arguments.of(17, 23, 1, true),
                Arguments.of(18, 24, 6, true),
                Arguments.of(30, 50, 10, true),
                Arguments.of(4, 5, 1, true),
                Arguments.of(25, 50, 25, true),
                Arguments.of(100, 200, 100, true),
                Arguments.of(3, 5, 3, false),
                Arguments.of(15, 25, 7, false)
        );
    }

    static Stream<Arguments> emailTestCases() {
        return Stream.of(
                Arguments.of("john.doe@example.com", true),
                Arguments.of("jane+doe@example.com", true),
                Arguments.of("john-doe@example.com", true),
                Arguments.of("jane_doe@example.com", true),
                Arguments.of("john.doe@sub.example.com", true),
                Arguments.of("john_doe@example.io", true),
                Arguments.of("john.doe@example.co.uk", true),
                Arguments.of("john.doe@example.travel", true),
                Arguments.of("john.doe@example.cloud", true),
                Arguments.of("john.doe@example.horse", true),
                Arguments.of("not-a-valid-email-address", false),
                Arguments.of("john.doe", false),
                Arguments.of("john.doe@", false),
                Arguments.of("john.doe@example", false),
                Arguments.of("john.doe@.com", false),
                Arguments.of("@example.com", false),
                Arguments.of("john.doe@111.222.333.444", false),
                Arguments.of("john.doe@example..com", false),
                Arguments.of("john.doe@example.-com", false)
        );
    }

    // Test cases for the algorithm "A sort function for a list of numbers in ascending order."
    @ParameterizedTest
    @MethodSource("sortNumbersTestCases")
    void sortNumbers(int[] input, int[] expectedOutput) {
        int[] result = Main.sortNumbers(input);
        assertArrayEquals(expectedOutput, result);
    }

    // Test cases for the algorithm "An algorithm to calculate the n-th Fibonacci number."
    @ParameterizedTest
    @MethodSource("fibonacciTestCases")
    void fibonacci(int n, int expectedOutput) {
        int result = Main.fibonacci(n);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    void isPalindrome(String input, boolean expectedOutput) {
        boolean result = Main.isPalindrome(input);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @MethodSource("gcdTestCases")
    void gcd(int a, int b, int expectedGcd, boolean isTrue) {
        if (isTrue) {
            assertEquals(expectedGcd, Main.gcd(a, b));
        } else {
            assertNotEquals(expectedGcd, Main.gcd(a, b));
        }
    }

    @ParameterizedTest
    @MethodSource("emailTestCases")
    void isValidEmail(String email, boolean expectedOutput) {
        boolean result = Main.isValidEmail(email);
        assertEquals(expectedOutput, result);
    }
}