package com.kronos.javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Q3_Combination {

    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        int number = 5;
        System.out.printf("Number : %d, denominations : %s\nUnique Possible Combinations:\n", number, Arrays.toString(denominations));
        printAllUniqueCombination(number, denominations);
    }

    private static void printAllUniqueCombination(int number, int[] denominations) {
        List<List<Integer>> combinations = new ArrayList<>();
        //We start with 0th index and taking sum as 0;
        findWays(0, 0, number, denominations, new ArrayList<>(), combinations);
        combinations.forEach(integers -> System.out.println(Arrays.deepToString(integers.toArray())));
    }

    /**
     * DFS searching of combinations.
     *
     * @param startIndex
     * @param sum                 interim sum of possible combinations
     * @param number              number for which we need to find unique combinations
     * @param denominations       set of fix denominations
     * @param possibleCombination potential combination
     * @param combinations        holder of all final combinations
     */
    private static void findWays(int startIndex, int sum, int number,
                                 int[] denominations, ArrayList<Integer> possibleCombination, List<List<Integer>> combinations) {
        if (sum > number) return;

        if (sum == number) {
            combinations.add(new ArrayList<>(possibleCombination));
            return;
        }
        IntStream.range(startIndex, denominations.length)
                .forEach(currentIndex -> {
                    possibleCombination.add(denominations[currentIndex]);
                    findWays(currentIndex, sum + denominations[currentIndex], number, denominations, possibleCombination, combinations);
                    possibleCombination.remove(possibleCombination.size() - 1);
                });
    }
}
