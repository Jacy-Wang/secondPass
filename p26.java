public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int val = nums[0];
        int pos = 0;
        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val) {
                if (!found) {
                    pos = i;
                    found = true;
                }
            } else {
                val = nums[i];
                if (found) {
                    int tmp = nums[i];
                    nums[i] = nums[pos];
                    nums[pos] = tmp;
                    pos++;
                }
            }
        }
        return found ? pos : nums.length;
    }
}
