class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int minCharIndex = 0;

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            stack.push(c);

            while (minCharIndex < 26 && freq[minCharIndex] == 0) {
                minCharIndex++;
            }

            while (!stack.isEmpty() && (stack.peek() - 'a') <= minCharIndex) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
