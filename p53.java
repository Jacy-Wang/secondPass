public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int maxSum = sum[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum[i - 1] <= 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = nums[i] + sum[i - 1];
            }
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }
}
