import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;

        // Each element in deque stores: [yi - xi, xi]
        Deque<int[]> dq = new ArrayDeque<>();

        for (int[] point : points) {
            int xj = point[0], yj = point[1];

            // Remove points outside the window
            while (!dq.isEmpty() && xj - dq.peekFirst()[1] > k) {
                dq.pollFirst();
            }

            // Update max value using front of deque
            if (!dq.isEmpty()) {
                max = Math.max(max, yj + xj + dq.peekFirst()[0]);
            }

            // Maintain deque: remove worse values from back
            while (!dq.isEmpty() && dq.peekLast()[0] <= yj - xj) {
                dq.pollLast();
            }

            dq.offerLast(new int[]{yj - xj, xj});
        }

        return max;
    }
}
