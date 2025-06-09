class Solution {
    public int jump(int[] nums) {
        int[] length = new int[nums.length];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                length[j] = Math.min(length[j], length[i] + 1);
            }
        }
        return length[nums.length - 1];
    }
}