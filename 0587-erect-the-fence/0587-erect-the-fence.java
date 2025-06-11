import java.util.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> lower = new ArrayList<>();
        for (int[] tree : trees) {
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) < 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(tree);
        }

        List<int[]> upper = new ArrayList<>();
        for (int i = trees.length - 1; i >= 0; i--) {
            int[] tree = trees[i];
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(tree);
        }

        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int[] p : lower) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) result.add(p);
        }
        for (int[] p : upper) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) result.add(p);
        }

        return result.toArray(new int[result.size()][]);
    }

    private int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }
}
