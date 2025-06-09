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
    private Map<Integer, Integer> inorderIndexMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderIndexMap.get(rootVal);

        root.right = helper(postorder, inIndex + 1, inRight);
        root.left = helper(postorder, inLeft, inIndex - 1);

        return root;
    }
}
