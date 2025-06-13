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
// Definition for a binary tree node.
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
 */
class Solution {
    public void getresult(TreeNode root, int[] result, int tempresult) {
        if (root == null) {
            return;
        }
        tempresult = tempresult * 10 + root.val;
        if (root.left == null && root.right == null) {
            result[0] += tempresult;
            return;
        }
        getresult(root.left, result, tempresult);
        getresult(root.right, result, tempresult);
    }

    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        int tempresult = 0;
        getresult(root, result, tempresult);
        return result[0];
    }
}