class Solution {
    public int numTrees(int n) {
        return fxn(n);
    }
    static int fxn(int n ){

        if (n <= 1) return 1;
        int total=0;
         for (int i = 0; i < n; i++) {
            total += fxn(i) * fxn(n - 1 - i); // left * right
        }
        return total;
    }
}