import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0; // index in popped

        for (int value : pushed) {
            stack.push(value);

            // Pop while the stack top matches the next required value
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
