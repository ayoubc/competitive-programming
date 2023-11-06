class Solution {
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new ArrayList[numCourses];
        visited = new int[numCourses];
        for(int i=0;i<numCourses;i++) list[i] = new ArrayList<>();

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            list[a].add(b);
        }

        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0) {
                if(isCyclic(i, list)) return false;
            }
        }
        return true;
    }
    public boolean isCyclic(int s, List<Integer>[] list) {
        if(visited[s] == 2) return true;

        visited[s] = 2;
        for(int i=0;i<list[s].size(); i++){
            int cur = list[s].get(i);
            if(visited[cur] != 1) {
                if(isCyclic(cur, list)) return true;
            }
        }

        visited[s] = 1;
        return false;
    }
}