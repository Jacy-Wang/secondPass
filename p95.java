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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<TreeNode>();
        return construct(1, n);
    }

    private ArrayList<TreeNode> construct(int start, int end) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        if (start > end) {
            lst.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                ArrayList<TreeNode> leftTrees = construct(start, i - 1);
                ArrayList<TreeNode> rightTrees = construct(i + 1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        lst.add(root);
                    }
                }
            }
        }
        return lst;
    }
}
