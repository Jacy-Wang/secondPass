/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        visited.put(node.label, cloned);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.removeFirst();
            UndirectedGraphNode copiedNode;
            if (!visited.containsKey(cur.label)) {
                copiedNode = new UndirectedGraphNode(cur.label);
                visited.put(copiedNode.label, copiedNode);
            } else {
                copiedNode = visited.get(cur.label);
            }
            for (int i = 0; i < cur.neighbors.size(); i++) {
                UndirectedGraphNode tmp = cur.neighbors.get(i);
                if (!visited.containsKey(tmp.label)) {
                    queue.addLast(tmp);
                    UndirectedGraphNode copiedTmp = new UndirectedGraphNode(tmp.label);
                    visited.put(tmp.label, copiedTmp);
                    copiedNode.neighbors.add(copiedTmp);
                } else {
                    copiedNode.neighbors.add(visited.get(tmp.label));
                }
            }
        }
        return cloned;
    }
}
