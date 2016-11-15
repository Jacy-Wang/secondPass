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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (p == root || q == root)
            return root;
        TreeNode ll = lowestCommonAncestor(root.left, p, q);
        TreeNode rr = lowestCommonAncestor(root.right, p, q);
        return ll == null ? rr : (rr == null ? ll : root);
    }
}
