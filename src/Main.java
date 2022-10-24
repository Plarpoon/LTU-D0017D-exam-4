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

        int[] arr; // Array to store the random numbers
        int temp; // Temporary variable to store the random number
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

                arr = new int[n]; // create an array with n elements
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error. Please enter a smaller number.");
            sc.close();
            return;
        }

        System.out.println(" ");

        arr = new int[n]; // Initializing the array

        for (int i = 0; i < n; i++) { // Loop to generate n random numbers
            arr[i] = RANDOM_NUMBER_GENERATOR(MIN, MAX);
        }

        System.out.println("Here are the random numbers: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Here are the random generated numbers arranged:");

        // Sorting the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        // Count the number of even numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        // Count the number of odd numbers
        oddCount = n - evenCount;

        System.out.println(
                "Of the above " + n + " random numbers, " + evenCount + " are even and " + oddCount + " are odd");

        sc.close();
    }
}