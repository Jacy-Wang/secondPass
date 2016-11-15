public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || nums.length < k)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx;
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty()) {
                idx = deque.peekLast();
                if (nums[idx] <= nums[i])
                    deque.removeLast();
                else
                    break;
            }
            deque.addLast(i);
            idx = deque.peekFirst();
            if (i - idx + 1 > k)
                deque.removeFirst();
            if (i >= k - 1) {
                idx = deque.peekFirst();
                res[i - k + 1] = nums[idx];
            }
        }
        return res;
    }
}
