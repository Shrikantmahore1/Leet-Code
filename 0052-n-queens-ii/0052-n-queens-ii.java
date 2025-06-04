class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }
    private int solveNQueens(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            return 1;
        }
        int totalSolutions = 0;
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row + col] || diag2[col - row + n - 1]) {
                continue;
            }
            cols[col] = true;
            diag1[row + col] = true;
            diag2[col - row + n - 1] = true;
            totalSolutions += solveNQueens(n, row + 1, cols, diag1, diag2);
            cols[col] = false;
            diag1[row + col] = false;
            diag2[col - row + n - 1] = false;
        }
        return totalSolutions; 
    }
}