import java.util.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (space-separated):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input: value of k
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + " = " + result);
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle subarrays starting from index 0
        int sum = 0;
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

