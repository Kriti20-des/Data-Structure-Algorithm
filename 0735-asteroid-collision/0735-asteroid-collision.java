class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int current = asteroids[i];

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && current < 0) {

                int top = stack.peek();

                if (top < -current) {
                    stack.pop();
                }
                else if (top == -current) {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(current);
            }
        }

        int[] ans = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}