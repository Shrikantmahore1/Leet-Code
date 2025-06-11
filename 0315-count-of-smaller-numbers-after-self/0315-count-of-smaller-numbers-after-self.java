import java.util.*;

class Solution {
    class Pair {
        int val, index;
        Pair(int v, int i) {
            val = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        int[] count = new int[n];
        mergeSort(pairs, 0, n - 1, count);
        for (int i = 0; i < n; i++) {
            result[i] = count[i];
        }
        return Arrays.asList(result);
    }

    private void mergeSort(Pair[] pairs, int left, int right, int[] count) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(pairs, left, mid, count);
        mergeSort(pairs, mid + 1, right, count);
        merge(pairs, left, mid, right, count);
    }

    private void merge(Pair[] pairs, int left, int mid, int right, int[] count) {
        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (pairs[i].val <= pairs[j].val) {
                count[pairs[i].index] += rightCount;
                temp.add(pairs[i++]);
            } else {
                rightCount++;
                temp.add(pairs[j++]);
            }
        }

        while (i <= mid) {
            count[pairs[i].index] += rightCount;
            temp.add(pairs[i++]);
        }

        while (j <= right) {
            temp.add(pairs[j++]);
        }

        for (int k = left; k <= right; k++) {
            pairs[k] = temp.get(k - left);
        }
    }
}
