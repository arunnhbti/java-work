import java.util.Scanner;

public class MaxSumSubArray
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int noOfElements = Integer.parseInt(scanner.nextLine());
        String elementsAsString = scanner.nextLine();
        int[] elements = {};
        int index = 0, start = 0, end = 0;
        boolean conti = true;

        for(String element : elementsAsString.split(" ")) {
            elements[index++] = Integer.parseInt(element);
        }

        int sum = elements[0];
        for(index = 1; index < noOfElements; index++) {

            int curr = elements[index];

            int sumTmp = Math.addExact(sum, curr);
            if(sum > 0) {
                if(sumTmp > 0) {
                    end = index;
                    conti = true;
                }
            } else {

            }


        }

    }

    private class Max {
        int sum = 0, start = 0, end = 0;
    }
}
