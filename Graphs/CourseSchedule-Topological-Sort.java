// Topological Sort - TC - O(V + E), SC - O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        List<List<Integer>> adj = new ArrayList();
        Queue<Integer> q = new LinkedList();

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }

        for(int i = 0; i < preq.length; i++) {
            adj.get(preq[i][0]).add(preq[i][1]);
            indegree[preq[i][1]]++;
        }

        // 1 -> {2, 3}
        // 2 -> {4}
        // 4 -> {1}
        // 3 -> {}
        // 0 -> {3, 4}
        // indegree - [0, 1, 0, 2, 2]
        // q -> {2, 3, 4}
        for(int i = 0; i < adj.size(); i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int polled = q.poll();

            for(int dep: adj.get(polled)) {
                indegree[dep]--;
                
                if(indegree[dep] == 0) {
                    q.add(dep);
                }
            }

            finish++;
        }

        return finish == numCourses;
    }   
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sort 
        int[] indegree = new int[numCourses];
        int finish = 0;

        Map<Integer, List<Integer>> adj = new HashMap();
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }

        for(int[] preq: prerequisites) {
            adj.get(preq[0]).add(preq[1]);
            indegree[preq[1]]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }     
          
        while(!q.isEmpty()) {
            int polled = q.poll();

            for(int dep: adj.get(polled)) {
                indegree[dep]--;
                
                if(indegree[dep] == 0) {
                    q.add(dep);
                }
            }

            finish++;
        }

        return finish == numCourses;
    }
}
