// TC - O(V + E), SC - O(V + E)
class Solution {
    public int[] findOrder(int numCourses, int[][] preq) {
        int[] result = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }   

        for(int i = 0; i < preq.length; i++) {
            indegree[preq[i][1]]++;
            adj.get(preq[i][0]).add(preq[i][1]);
        }        


        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < adj.size(); i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }


        // 1 -> 0
        // 2 -> 0
        // 3 -> {1, 2}
        // 0 -> {}

        // indegree -> [2, 0, 0, 0]
        // q -> {1, 2, }
        int finish = 0;
        while(!q.isEmpty()) {
            int polled = q.poll();
            indegree[polled]--;

            for(int dep: adj.get(polled)) {
                indegree[dep]--;

                if(indegree[dep] == 0) {
                    q.add(dep);
                }
            }

            result[numCourses - finish - 1] = polled; 
            finish++;
        }

        return finish == numCourses ? result: new int[]{};
    }
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap();

        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }

        for(int[] preq: prerequisites) {
            adj.get(preq[0]).add(preq[1]);
            indegree[preq[1]]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int n = numCourses - 1;
        while(!q.isEmpty()) {
            int polled = q.poll();
            result[n--] = polled; 

            for(int dep: adj.get(polled)) {
                indegree[dep]--;
                if(indegree[dep] == 0) {
                    q.add(dep);
                }
            }
        }

        return n == -1 ? result: new int[0];
    }
}