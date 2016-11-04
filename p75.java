public class Solution {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = -1;
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        if (i == nums.length)
            return;
        left = i;
        i = nums.length - 1;
        while (i >= 0 && nums[i] == 2) {
            i--;
        }
        if (i < 0)
            return;
        right = i;
        i = left;
        while (i <= right && left <= right) {
            if (i == right && nums[i] == 1)
                break;
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
