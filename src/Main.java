
/**
 * ===============================================================
 * What does the program do:
 * The program should ask the user to enter a number, create as many
 * random numbers as the number entered by the user, sort the numbers
 * and then display them first even and then odd.
 * ===============================================================
 * Pseudocode steps:
 * 1. Ask the user to enter a number
 * 2. Generate random numbers as many as the number entered by the user
 * 3. Sort the numbers
 * 4. Print the numbers first even and then odd
 * 5. Count the number of even and odd numbers
 * 6. Print the number of even and odd numbers
 * ===============================================================
 * Alessandro Suha
 * alesuh-1
 */

import java.util.Scanner;
import java.util.Random;

class Main {
    public static int RANDOM_NUMBER_GENERATOR(int MIN, int MAX) { // Generates a random number between 1 and 6
        Random r = new Random();
        int randomNum = r.nextInt(MAX - MIN);
        int result = randomNum + MIN;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MIN = 1; // Minimum number +1 because 0 is neither even nor odd
        final int MAX = 999; // Maximum number
        final String ERROR = "Please enter a positive number higher than 0: ";

        int[] array; // Array to store the random numbers
        int n; // Number of random numbers to be generated
        int evenCount = 0; // Number of even numbers
        int oddCount = 0; // Number of odd numbers

        System.out.print("How many random numbers in the range 0 - 999 are desired? ");

        // make sure n is a valid integer
        while (!sc.hasNextInt()) {
            System.out.print(ERROR);
            sc.next();
        }

        // try catch n is out of memory
        try {
            n = sc.nextInt();

            // check if n is bigger than MIN
            while (n < MIN) {
                System.out.print(ERROR);

                array = new int[n]; // create an array with n elements
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error. Please enter a smaller number.");
            sc.close();
            return;
        }

        System.out.println(" ");
        array = new int[n]; // Initializing the array
        for (int i = 0; i < n; i++) { // Loop to generate n random numbers
            array[i] = RANDOM_NUMBER_GENERATOR(MIN, MAX);
        }

        // Print the array
        System.out.println("Here are the random numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");

        // Bubble sort the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Here are the random numbers arranged:");
        // Print all the even numbers first and then the odd numbers
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
                evenCount++;
            }
        }
        System.out.print("- ");
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
                oddCount++;
            }
        }

        System.out.println(
                "\n\nOf the above " + n + " numbers, " + evenCount + " were even and " + oddCount + " odd");

        sc.close();
    }
}