class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int operations = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE, idx = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            int merged = list.get(idx) + list.get(idx + 1);
            list.remove(idx + 1);
            list.set(idx, merged);
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
}
