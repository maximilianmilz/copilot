package org.example;

public class Main {
    // A sort function for a list of numbers in ascending order.
    public static int[] sortNumbers(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < (numbers.length - i); j++) {
                if (numbers[j - 1] > numbers[j]) {
                    //swap elements
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    // An algorithm to calculate the n-th Fibonacci number.
    public static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }


    // A function to check if a given string is a palindrome.
    public static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    // An algorithm to determine the greatest common divisor of two numbers.
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    // A function to check if a given string is a valid email address using a regular expression.
    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}