import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        // List to hold all the critical points (start and end)
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]}); // start point has negative height
            points.add(new int[]{b[1], b[2]});  // end point has positive height
        }

        // Sort by x coordinate; for tie, sort by height
        points.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Max-heap to keep track of heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // ground level

        int prevMaxHeight = 0;

        for (int[] p : points) {
            int x = p[0];
            int h = p[1];

            if (h < 0) {
                maxHeap.add(-h); // building start
            } else {
                maxHeap.remove(h); // building end
            }

            int currentMaxHeight = maxHeap.peek();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}
