/*Title: Activity Selection Problem
Description:
You are given n activities with start and end times. Select the maximum number of activities that can be performed by a single person, as
Input Format:
n
start1 end1
start2 end2
...
startn endn
Output Format:
Maximum number of non-overlapping activities
Sample Input:
6
1 3
2 4
3 5
0 6
5 7
8 9
Sample Output:
4
Greedy Approach:
Sort activities by end time. Always pick the next activity that starts after the last selected activity ends.*/

//CODE 
import java.util.*;

public class ActivitySelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] activities = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
        }
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int lastEnd = activities[0][1];
        
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastEnd) {
                count++;
                lastEnd = activities[i][1];
            }
        }
        
        System.out.println(count);
        scanner.close();
    }
}
