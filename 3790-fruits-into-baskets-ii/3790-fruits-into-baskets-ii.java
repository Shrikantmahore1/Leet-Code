class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(b[j] >= f[i] && !set.contains(j)) {
                    set.add(j);
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}