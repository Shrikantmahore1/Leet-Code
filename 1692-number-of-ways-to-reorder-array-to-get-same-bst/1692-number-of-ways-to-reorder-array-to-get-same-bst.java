import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];
        buildComb(n);
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) numList.add(num);
        return (int)((dfs(numList) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        // Ways to interleave left and right: C(l + r, l)
        long interleaveWays = comb[left.size() + right.size()][left.size()];
        return (((interleaveWays * leftWays) % MOD) * rightWays) % MOD;
    }

    private void buildComb(int n) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
    }
}
