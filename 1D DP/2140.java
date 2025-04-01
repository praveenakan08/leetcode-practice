class Solution {

    public long mostPoints(int[][] questions) {
        // using backtracking - time limit exceeded
        return dfs(0, questions);
    }

    private long dfs(int i, int[][] questions) {
        if(i >= questions.length) {
            return 0;
        }
        
        return Math.max(dfs(i + 1, questions),
                        questions[i][0] + dfs(i + 1 + questions[i][1], questions));
    }

   // using top down approach
class Solution {

    public long mostPoints(int[][] questions) {
        
        long cache[] = new long[questions.length];
        Arrays.fill(cache, -1);

        return backtrack(0, questions, cache);
    }

    private long backtrack(int i, int[][] questions, long[] cache) {
        if(i >= questions.length) {
            return 0;
        }

        if(cache[i] != -1) {
            return cache[i];
        }
        
        cache[i] = Math.max(backtrack(i + 1, questions, cache), // skip 
                        questions[i][0] + backtrack(i + 1 + questions[i][1], questions, cache)); //choose

        return cache[i];
    }

    class Solution {

    public long mostPoints(int[][] questions) {
        // using bottom up approach
        long cache[] = new long[questions.length];

        for(int i = questions.length - 1; i >= 0; i--) {
            int nextIndex = i + 1 + questions[i][1];
            long skip = i + 1 < questions.length ? cache[i + 1]: 0;
            long choose = nextIndex < questions.length ? cache[nextIndex] + questions[i][0]: questions[i][0]; 

            cache[i] = Math.max(skip, choose);
        }     

        return cache[0];
    }
}


}


}