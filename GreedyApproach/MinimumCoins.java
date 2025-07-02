import java.util.*;

public class MinimumCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read amount
        int amount = sc.nextInt();
        // Read denominations (space-separated)
        sc.nextLine(); // consume the remaining newline
        String[] denomStrings = sc.nextLine().split(" ");
        int[] denominations = new int[denomStrings.length];
        for (int i = 0; i < denomStrings.length; i++) {
            denominations[i] = Integer.parseInt(denomStrings[i]);
        }

        // Sort denominations in descending order
        Arrays.sort(denominations);
        for (int i = 0, j = denominations.length - 1; i < j; i++, j--) {
            int temp = denominations[i];
            denominations[i] = denominations[j];
            denominations[j] = temp;
        }

        int count = 0;
        int remaining = amount;

        for (int coin : denominations) {
            if (coin <= remaining) {
                int numCoins = remaining / coin;
                count += numCoins;
                remaining -= numCoins * coin;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
