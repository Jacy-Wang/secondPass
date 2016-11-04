/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        recursiveFlatten(dummy, root);
    }
    
    private TreeNode recursiveFlatten(TreeNode cur, TreeNode node) {
        if (node == null) {
            return cur;
        }
        cur.left = null;
        cur.right = node;
        cur = node;
        TreeNode rightNode = node.right;
        cur = recursiveFlatten(cur, node.left);
        return recursiveFlatten(cur, rightNode);
    }
}
