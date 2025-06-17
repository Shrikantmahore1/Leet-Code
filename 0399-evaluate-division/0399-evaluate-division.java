class Solution {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    
    boolean dfs(String src, String dst, double[] value) {
        if (src.equals(dst)) {
            value[0] = 1.0;
            return true;
        }
        visited.add(src);
        for (String nx : graph.get(src).keySet()) {
            if (visited.contains(nx)) continue;
            double temp = graph.get(src).get(nx);
            if (dfs(nx, dst, value)) {
                value[0] *= temp;
                return true;
            }
        }
        return false;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            graph.putIfAbsent(eq.get(0), new HashMap<>());
            graph.putIfAbsent(eq.get(1), new HashMap<>());
            graph.get(eq.get(0)).put(eq.get(1), values[i]);
            graph.get(eq.get(1)).put(eq.get(0), 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String src = q.get(0);
            String dst = q.get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                res[i] = -1.0;
                continue;
            }
            if (src.equals(dst)) {
                res[i] = 1.0;
                continue;
            }
            visited.clear();
            double[] value = new double[] {1.0};

            if (dfs(src, dst, value)) res[i] = value[0];
            else res[i] = -1.0;
        }
        return res;
    }
}

