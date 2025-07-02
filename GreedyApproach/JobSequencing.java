import java.util.*;

class Job {
    String id;
    int deadline, profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of jobs
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        // Read job data
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        // Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline to determine number of slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create time slots, -1 means empty
        String[] slots = new String[maxDeadline + 1]; // 1-based indexing
        Arrays.fill(slots, null);

        int totalProfit = 0;

        // Try to schedule each job
        for (Job job : jobs) {
            // Find a slot for this job (latest possible before deadline)
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == null) {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println(totalProfit);
        sc.close();
    }
}
