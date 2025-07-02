import java.util.*;

class Item {
    int value, weight;
    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        ArrayList<Item> items = new ArrayList<>();

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; ++i) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items.add(new Item(value, weight));
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort items by value/weight ratio in descending order
        items.sort((a, b) -> {
            double r1 = (double)a.value / a.weight;
            double r2 = (double)b.value / b.weight;
            return Double.compare(r2, r1); // Descending order
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double)capacity / item.weight);
                break;
            }
        }

        System.out.printf("Maximum value: %.2f\n", totalValue);

        sc.close();
    }
}
