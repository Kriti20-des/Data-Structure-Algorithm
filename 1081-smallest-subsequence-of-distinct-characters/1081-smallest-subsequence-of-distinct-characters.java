class Solution {
    public String smallestSubsequence(String s) {
        
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (seen[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                seen[removed - 'a'] = false;
            }

            stack.append(ch);
            seen[ch - 'a'] = true;
        }

        return stack.toString();
    }
}