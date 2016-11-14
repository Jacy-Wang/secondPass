public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = 0;
        }
        ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            neighbors.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!visit(i, visited, neighbors))
                    return false;
            }
        }
        return true;
    }
    
    public boolean visit(int node, int[] visited, ArrayList<ArrayList<Integer>> neighbors) {
        if (visited[node] == 1)
            return true;
        if (visited[node] == -1)
            return false;
        visited[node] = -1;
        for (int i = 0; i < neighbors.get(node).size(); i++) {
            if (!visit(neighbors.get(node).get(i), visited, neighbors))
                return false;
        }
        visited[node] = 1;
        return true;
    }
}
