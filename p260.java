public class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp;
        int mask = 1;
        int digit = -1;
        for (int j = 0; j < 32; j++) {
            if (digit != -1)
                break;
            tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp += ((nums[i] >> j) & mask);
            }
            if (tmp % 2 == 1) {
                digit = j;
                break;
            }
        }
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & (1 << digit)) == 0) {
                val1 ^= nums[i];
            } else {
                val2 ^= nums[i];
            }
        }
        return new int[]{val1, val2};
    }
}
