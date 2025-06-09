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

    int pointer = 0;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    pointer = postorder.length - 1;
    return build(postorder.length - 1, 0, inorder, postorder);
  }

  private TreeNode build(int inorderStart, int inorderEnd, int[] inorder, int[] postorder) {
    if (inorderStart < inorderEnd) {
      return null;
    }
    int topI = getTopI(postorder[pointer], inorder, inorderStart, inorderEnd);
    TreeNode node = new TreeNode(postorder[pointer]);
    pointer--;
    node.right = build(inorderStart, topI + 1, inorder, postorder);
    node.left = build(topI - 1, inorderEnd, inorder, postorder);
    return node;
  }

  public int getTopI(int val, int[] inorder, int start, int end) {
    while (start > end && inorder[start] != val && inorder[end] != val) {
      start--;
      end++;
    }
    return inorder[start] == val ? start : end;
  }
}