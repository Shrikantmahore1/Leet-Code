class Solution {
    public long distributeCandies(int n, int limit) {
        return countWays(n, limit);
    }

    private long countWays(int n, int limit) {
        long total = comb(n + 2, 2);
        long bad = 0;

        for (int mask = 1; mask < 8; mask++) {
            int bits = Integer.bitCount(mask);
            int sum = n - (limit + 1) * bits;
            if (sum < 0) continue;
            long ways = comb(sum + 2, 2);
            if (bits % 2 == 1) {
                bad += ways;
            } else {
                bad -= ways;
            }
        }

        return total - bad;
    }

    private long comb(int n, int k) {
        if (n < k) return 0;
        if (k == 2) return (long)n * (n - 1) / 2;
        if (k == 1) return n;
        if (k == 0 || k == n) return 1;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res *= n - (i - 1);
            res /= i;
        }
        return res;
    }
}
