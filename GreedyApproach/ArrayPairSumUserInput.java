import java.util.*;

public class ArrayPairSumUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of elements (should be even)
        System.out.print("Enter number of elements (even number): ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input: array elements
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call the function and print result
        int sum = arrayPairSum(nums);
        System.out.println("Maximum sum of min of pairs: " + sum);

        sc.close();
    }

    // The original logic
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
