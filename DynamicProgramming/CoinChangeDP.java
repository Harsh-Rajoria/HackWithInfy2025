import java.util.*;
public class CoinChangeDP {
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    if (dp[i] > dp[i - coin] + 1) {
                        dp[i] = dp[i - coin] + 1;
                        lastCoin[i] = coin;
                    }
                }
            }
        }

        // Print the coins used (optional)
        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println("No solution possible.");
            return -1;
        } else {
            System.out.print("Coins used: ");
            int a = amount;
            while (a > 0) {
                System.out.print(lastCoin[a] + " ");
                a -= lastCoin[a];
            }
            System.out.println();
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 9};
        int amount = 11;
        int result = minCoins(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}
