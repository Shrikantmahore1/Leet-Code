class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] opened = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> boxes = new HashSet<>();

        for (int box : initialBoxes) {
            boxes.add(box);
        }

        int totalCandies = 0;
        boolean progress = true;

        while (progress) {
            progress = false;
            List<Integer> toOpen = new ArrayList<>();

            for (int box : boxes) {
                if ((status[box] == 1 || hasKey[box]) && !opened[box]) {
                    toOpen.add(box);
                }
            }

            for (int box : toOpen) {
                boxes.remove(box);
                opened[box] = true;
                totalCandies += candies[box];
                progress = true;

                for (int key : keys[box]) {
                    hasKey[key] = true;
                }

                for (int contained : containedBoxes[box]) {
                    boxes.add(contained);
                }
            }
        }

        return totalCandies;
    }
}
