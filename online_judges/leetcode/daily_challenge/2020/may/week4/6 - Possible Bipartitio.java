class Solution {
    public static int[] visited;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        visited = new int[N+1];
        for(int i=1;i<=N;i++) visited[i] = -1;
        List<Integer>[] adjacent = new List[N+1];
        for(int i=1;i<=N;i++) adjacent[i] = new ArrayList<>();
        for(int i=0;i<dislikes.length;i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            adjacent[a].add(b);
            adjacent[b].add(a);
        }


        for(int i=1;i<=N;i++){
            if(visited[i] == -1) {
                if(!noOddCycles(i, adjacent)) return false;
            }
        }
        return true;
    }
    public static boolean noOddCycles(int s, List<Integer>[] adjacent){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = 1;
        q.add(s);
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<adjacent[cur].size();i++){
                int j = adjacent[cur].get(i);
                if(visited[j] == -1){
                    visited[j] = 1 - visited[cur];
                    q.add(j);
                }
                else if(visited[j] == visited[cur]) return false;
            }
        }
        return true;
    }
}