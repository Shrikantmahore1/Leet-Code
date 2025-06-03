import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int freqA = freq.get(a);
            int freqB = freq.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // sort by increasing frequency
            } else {
                return b - a; // sort by decreasing value if frequency is the same
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }

        return nums;
    }
}
