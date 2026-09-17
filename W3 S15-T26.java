import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision only happens when stack top moves right
            // and current asteroid moves left.
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    stack.pop(); // top asteroid is destroyed
                } else if (top == -asteroid) {
                    stack.pop(); // both are destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // current asteroid is destroyed
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
