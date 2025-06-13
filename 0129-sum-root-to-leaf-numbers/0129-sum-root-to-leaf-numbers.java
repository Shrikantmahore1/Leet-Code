/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static void dfs (TreeNode node, String s, ArrayList paths) {
        if (node.left == null && node.right == null) {
            paths.add(s + Integer.toString(node.val));
        }
        if (node.left != null) {
            dfs(node.left, s + Integer.toString(node.val), paths);
        }
        if (node.right != null) {
            dfs(node.right, s + Integer.toString(node.val), paths);
        }
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        dfs(root, "", paths);

        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }
}