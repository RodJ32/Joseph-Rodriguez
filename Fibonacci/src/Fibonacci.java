import java.util.Scanner;

public class Fibonacci {

    private static long[] fibonacciCache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        fibonacciCache = new long[n + 1];

        long result = fibonacci(n);
        System.out.println("This Fibonacci number at position -> " + n + " equals this: " + result);
    }
    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFibonacciNumber = (fibonacci(n-1) + fibonacci(n-2));
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }
}
