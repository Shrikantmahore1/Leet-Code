class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int maxNum = getMax(numStr);
        int minNum = getMin(numStr);
        return maxNum - minNum;
    }

    // Function to maximize the number
    private int getMax(String numStr) {
        char[] chars = numStr.toCharArray();
        char target = ' ';
        
        // Find the first digit that is not '9'
        for (char c : chars) {
            if (c != '9') {
                target = c;
                break;
            }
        }
        
        // If already all 9s
        if (target == ' ') return Integer.parseInt(numStr);

        // Replace all target digits with '9'
        StringBuilder maxStr = new StringBuilder();
        for (char c : chars) {
            if (c == target) {
                maxStr.append('9');
            } else {
                maxStr.append(c);
            }
        }
        return Integer.parseInt(maxStr.toString());
    }

    // Function to minimize the number
    private int getMin(String numStr) {
        char[] chars = numStr.toCharArray();
        char target = ' ';

        if (chars[0] != '1') {
            target = chars[0];
            // Replace all target digits with '1'
            StringBuilder minStr = new StringBuilder();
            for (char c : chars) {
                if (c == target) {
                    minStr.append('1');
                } else {
                    minStr.append(c);
                }
            }
            return Integer.parseInt(minStr.toString());
        } else {
            // Start from second digit
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != '0' && chars[i] != '1') {
                    target = chars[i];
                    break;
                }
            }

            if (target == ' ') return Integer.parseInt(numStr);

            StringBuilder minStr = new StringBuilder();
            for (char c : chars) {
                if (c == target) {
                    minStr.append('0');
                } else {
                    minStr.append(c);
                }
            }
            return Integer.parseInt(minStr.toString());
        }
    }
}