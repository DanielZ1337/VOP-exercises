import java.util.Scanner;

public class _18_2 {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));
    }

    public static long fib(long n) {
        long currentFib = 0;
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        for (int i = 1; i < n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }
        return currentFib;
    }
}