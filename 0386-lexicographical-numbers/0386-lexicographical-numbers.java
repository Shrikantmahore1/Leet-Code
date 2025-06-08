import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int num = 1;
        for (int i = 0; i < n; i++) {
            result.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return result;
    }
}
