class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        // Skip invalid closing parentheses
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                result.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }

        // Remove extra opening parentheses from right to left
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            } else {
                answer.append(ch);
            }
        }

        return answer.reverse().toString();
    }
}
