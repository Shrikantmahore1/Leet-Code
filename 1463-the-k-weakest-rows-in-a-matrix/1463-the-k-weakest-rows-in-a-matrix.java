import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[][] strength = new int[m][2]; // [soldierCount, rowIndex]

        for (int i = 0; i < m; i++) {
            strength[i][0] = countSoldiers(mat[i]);
            strength[i][1] = i;
        }

        Arrays.sort(strength, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // if same soldier count, compare index
            return a[0] - b[0]; // otherwise compare soldier count
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = strength[i][1];
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; 
    }
}
