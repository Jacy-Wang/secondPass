public class Solution {
    public void moveZeroes(int[] nums) {
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (pos != -1) {
                    nums[pos] = nums[i];
                    pos++;
                }
            } else {
                if (pos == -1) {
                    pos = i;
                }
            }
        }
        if (pos != -1) {
            for (int i = pos; i < nums.length; i++)
                nums[i] = 0;
        }
    }
}
