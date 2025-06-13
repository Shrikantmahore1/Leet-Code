class Solution {
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) return false;
        }

        // row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) return false;
        }

        // 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) return true;  // board complete

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        int[][] sudoku = new int[9][9];

       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    sudoku[i][j] = 0;
                } else {
                    sudoku[i][j] = board[i][j] - '0';
                }
            }
        }

        sudokuSolver(sudoku, 0, 0);

       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (sudoku[i][j] + '0');
            }
        }
    }
}