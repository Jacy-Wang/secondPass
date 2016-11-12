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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getNodes(root, -1, -1, nodes);
        return nodes;
    }
    
    public int getNodes(TreeNode root, int maxLevel, int level, List<Integer> nodes) {
        if (root == null) {
            return maxLevel;
        }
        if (level + 1 > maxLevel) {
            maxLevel = level + 1;
            nodes.add(root.val);
        }
        level++;
        int tmp = getNodes(root.right, maxLevel, level, nodes);
        return getNodes(root.left, tmp, level, nodes);
    }
}
