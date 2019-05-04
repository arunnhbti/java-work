package com.kronos.javatest;

import java.util.Objects;
import java.util.stream.IntStream;

public class Q1_RotateChars {

    private static final int N26 = 26;
    private static final int ASCII_a = 'a';

    public static void main(String[] args) {
        String text = "abcxyz";
        System.out.println(text + " ==> " + cipher(text, 3));
        text = "test second";
        System.out.println(text + " ==> " + cipher(text, 4));
        text = "123";
        System.out.println(text + " ==> " + cipher(text, 4));
    }

    /**
     * Util method to rotate all chars of given string by a specific given number.<br>
     * Work only for lower case string.
     *
     * @param text input text.
     * @param n    number by which wants to rotate each letter.
     * @return rotated string
     */
    public static String cipher(String text, int n) {

        Objects.requireNonNull(text, "Input text cannot be NULL.");
        int length = text.length();
        char[] encryptedText = new char[length];
        IntStream.range(0, length).forEach(i -> {
            int rel_index = text.charAt(i) - ASCII_a;
            encryptedText[i] = (rel_index >= 0 && rel_index < N26)
                    ? (char) ((rel_index + n) % N26 + ASCII_a)
                    : text.charAt(i);
        });
        return String.valueOf(encryptedText);
    }
}
