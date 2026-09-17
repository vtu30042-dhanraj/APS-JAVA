import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>(); // decreasing values
        Deque<Integer> minDeque = new ArrayDeque<>(); // increasing values

        int left = 0;
        int longest = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink window until max - min is within the limit
            while ((long) nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
