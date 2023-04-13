import java.util.Scanner;

public class _18_7 {

    static int fibRecCount = 0;

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));

        // Display the amount of times the fib method is called
        System.out.println("Amount of times the fib method has been called is " + fibRecCount);
    }

    /**
     * The method for finding the Fibonacci number
     */
    public static long fib(long index) {
        fibRecCount++;
        if (index == 0) // Base case
            return 0;
        else if (index == 1) // Base case
            return 1;
        else // Reduction and recursive calls
            return fib(index - 1) + fib(index - 2);
    }

}