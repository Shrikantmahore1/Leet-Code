class Solution {
    static final int MOD = 1_000_000_007;
    static long[] factorial;
    static long[] invFactorial;

    static long modExp(long base, int exp) {
        long result = 1;
        long power = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * power % MOD;
            power = power * power % MOD;
            exp /= 2;
        }
        return result;
    }

    static void precomputeFactorials(int n) {
        factorial = new long[n + 1];
        invFactorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i % MOD;
        invFactorial[n] = modExp(factorial[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k < 0 || k > n - 1) return 0;
        precomputeFactorials(n);
        long result = comb(n - 1, k);
        result = result * m % MOD;
        result = result * modExp(1, k) % MOD;
        result = result * modExp(m - 1, n - 1 - k) % MOD;
        return (int) result;
    }
}
