import java.util.*;

class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> valToIndices;
    private Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        valToIndices = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !valToIndices.containsKey(val);
        valToIndices.putIfAbsent(val, new HashSet<>());
        valToIndices.get(val).add(nums.size());
        nums.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty()) {
            return false;
        }

        int removeIdx = valToIndices.get(val).iterator().next();
        valToIndices.get(val).remove(removeIdx);

        int lastElement = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastElement);

        if (removeIdx != nums.size() - 1) {
            valToIndices.get(lastElement).remove(nums.size() - 1);
            valToIndices.get(lastElement).add(removeIdx);
        }

        nums.remove(nums.size() - 1);

        if (valToIndices.get(val).isEmpty()) {
            valToIndices.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
