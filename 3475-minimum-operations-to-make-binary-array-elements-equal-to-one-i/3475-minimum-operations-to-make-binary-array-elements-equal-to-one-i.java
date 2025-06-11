class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;
        int ops = 0;

        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= 3) {
                flip ^= isFlipped[i - 3];
            }

            if ((nums[i] ^ flip) == 0) {
                if (i + 2 >= n) return -1;
                ops++;
                flip ^= 1;
                isFlipped[i] = 1;
            }
        }

        return ops;
    }
}
