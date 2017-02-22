package com.arun.hackerrank.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeirdNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            int num = Integer.parseInt(input);
            if ((num & 1) == 0) {
                if ((num >= 2) && (num <= 5)) {
                    System.out.println("Not Weird");
                } else if ((num >= 6) && (num <= 20)) {
                    System.out.println("Weird");
                } else if (num > 20) {
                    System.out.println("Not Weird");
                }
            } else {
                System.out.println("Weird");
            }
        } catch (IOException e) {
            System.err.println("Error reading input stream.");
        }

    }

}
