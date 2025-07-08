import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of steps (n): ");
        int n = scanner.nextInt();

        // Handle edge cases for n <= 0
        if (n <= 0) {
            System.out.println("Number of steps must be a positive integer.");
            return;
        }

        // Array to store the number of ways to reach each step
        int[] ways = new int[n + 1];

        // Base cases
        ways[0] = 1; // 1 way to stay at the ground (do nothing)
        ways[1] = 1; // 1 way to reach the first step

        // Calculate ways for each step from 2 to n
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        System.out.println("Number of ways to climb " + n + " steps: " + ways[n]);
    }
}
