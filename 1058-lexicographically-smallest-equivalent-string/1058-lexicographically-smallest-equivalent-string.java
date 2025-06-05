class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            union(parent, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append((char)(find(parent, c - 'a') + 'a'));
        }
        return result.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) return;
        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}
