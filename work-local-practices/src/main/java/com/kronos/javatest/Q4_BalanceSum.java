package com.kronos.javatest;

import java.util.Arrays;

public class Q4_BalanceSum {
    public static void main(String[] args) {
        //Use cases
        //Use case - 1
        int[] numbers = new int[]{1, 2, 3, 6, 9, 7, 5, -33, 0};
        System.out.println(Arrays.toString(numbers) + " is balanced : " + balanceSum(numbers));
        //Use case - 2
        numbers = new int[]{1, 2, 3, 6, 9, 7, 5};
        System.out.println(Arrays.toString(numbers) + " is balanced : " + balanceSum(numbers));
` `        //Use case - 3
        numbers = new int[]{1, 2, 3, 6, 8, 7, 11};
        System.out.println(Arrays.toString(numbers) + " is balanced : " + balanceSum(numbers));
    }

    /**
     * Util method to find whether given array of integers is balanced,
     * at least for one element.
     *
     * @param numbers array or integers.
     * @return String YES if given ints are balanced for at least one element else NO.
     */
    private static String balanceSum(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        int rightSum, leftSum = 0;
        for (int index = 1; index < numbers.length; index++) {
            leftSum += numbers[index - 1];
            rightSum = sum - (leftSum + numbers[index]);
            if (rightSum == leftSum) return "YES";
        }
        return "NO";
    }
}
