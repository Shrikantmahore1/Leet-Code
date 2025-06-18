class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        
        // Get max by changing first non-9 digit to 9
        char targetMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                targetMax = c;
                break;
            }
        }
        String maxStr = targetMax == ' ' ? s : s.replace(targetMax, '9');
        
       
        char targetMin = s.charAt(0);
        String minStr = s.replace(targetMin, '0');

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
