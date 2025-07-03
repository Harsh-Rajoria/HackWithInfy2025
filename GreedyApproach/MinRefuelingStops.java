import java.util.*;

public class MinRefuelingStops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read target and starting fuel
        int target = sc.nextInt();
        int startFuel = sc.nextInt();

        // Read number of stations
        int n = sc.nextInt();
        int[][] stations = new int[n][2];

        for (int i = 0; i < n; i++) {
            stations[i][0] = sc.nextInt(); // distance
            stations[i][1] = sc.nextInt(); // fuel
        }

        // Max-heap to store fuel from reachable stations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel, stops = 0, i = 0;

        while (fuel < target) {
            // Add all stations within reach to the heap
            while (i < n && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            // If no station to refuel from, not possible
            if (maxHeap.isEmpty()) {
                System.out.println(-1);
                return;
            }
            // Refuel with the largest available fuel
            fuel += maxHeap.poll();
            stops++;
        }

        System.out.println(stops);
        sc.close();
    }
}
