public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] v = new int[nums.length];
        v[0] = 0;
        v[1] = nums[0];
        int maxV = v[1];
        for (int i = 1; i < nums.length - 1; i++) {
            v[i + 1] = Math.max(v[i], v[i - 1] + nums[i]);
            maxV = Math.max(maxV, v[i + 1]);
        }
        v[1] = nums[1];
        maxV = Math.max(maxV, v[1]);
        for (int i = 2; i < nums.length; i++) {
            v[i] = Math.max(v[i - 1], v[i - 2] + nums[i]);
            maxV = Math.max(maxV, v[i]);
        }
        return maxV;
    }
}
