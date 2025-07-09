import java.util.*;

public class MaxEventsAttend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt(); // start day
            events[i][1] = sc.nextInt(); // end day
        }
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, attended = 0, n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            // Remove events that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            } else if (i < n) {
                day = events[i][0];
            }
        }
        return attended;
    }
}
