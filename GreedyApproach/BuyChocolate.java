import java.util.*;

public class BuyChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of chocolates
        System.out.print("Enter number of chocolates: ");
        int n = sc.nextInt();

        // Input: prices
        int[] prices = new int[n];
        System.out.print("Enter prices of chocolates: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Input: money
        System.out.print("Enter amount of money: ");
        int money = sc.nextInt();

        // Find two minimum prices
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }

        int minCost = min1 + min2;
        int result;
        if (minCost > money) {
            result = money;
        } else {
            result = money - minCost;
        }

        System.out.println("Result: " + result);
        sc.close();
    }
}
