class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = square(slow);
            fast = square(square(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                return false;
            }
        }
    }

    public int square(int num) {
        int ans = 0;

        while (num > 0) {
            int x = num % 10;
            ans += x * x;
            num = num / 10;
        }

        return ans;
    }
}