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
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Check if current subtree is a BST
        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            int sum = node.val + left[3] + right[3];
            maxSum = Math.max(maxSum, sum);
            return new int[]{1, Math.min(node.val, left[1]), Math.max(node.val, right[2]), sum};
        }

        return new int[]{0, 0, 0, 0};  // Not a BST
    }
}
