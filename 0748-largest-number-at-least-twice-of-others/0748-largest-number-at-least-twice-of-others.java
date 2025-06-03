class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int secondMax = -1;
        int index = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        
        return max >= 2 * secondMax ? index : -1;
    }
}
