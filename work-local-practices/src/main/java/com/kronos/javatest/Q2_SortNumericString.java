package com.kronos.javatest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Util class to sort numeric strings where each string represent a positive number
 * within the range from 1 to 10^6 digits.
 */
public class Q2_SortNumericString {

    public static void main(String[] args) {
        //Sample data
        String[] myNumericStrings = new String[]{
                "1",
                "2",
                "98989",
                "8",
                "878787899",
                "7788",
                "898090988",
                "1000000000",
                "56"
        };
        System.out.println(Arrays.deepToString(bigSorting(myNumericStrings)));
    }

    public static String[] bigSorting(String[] numericStrings) {

        Arrays.sort(numericStrings, Comparator.comparingInt(Integer::parseInt));
        return numericStrings;
    }
}
