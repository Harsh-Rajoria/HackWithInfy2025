import java.util.Scanner;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        int prev2 = cost[0];
        int prev1 = cost[1];
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();
        int[] cost = new int[n];
        System.out.println("Enter the cost for each stair:");
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int result = minCostClimbingStairs(cost);
        System.out.println("Minimum cost to reach the top: " + result);
    }
}
