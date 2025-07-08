import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (0 <= n <= 30): ");
        int n = scanner.nextInt();

        if (n < 0 || n > 30) {
            System.out.println("Input must be between 0 and 30.");
            return;
        }

        int[] fib = new int[n + 2]; // To handle n = 0 case
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("The " + n + "th Fibonacci number is: " + fib[n]);
    }
}
