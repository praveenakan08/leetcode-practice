class Solution {
    public int[] JobScheduling(int[][] jobs) {

      // 1. sort the rows based on profit in desc
      // 2. pick the job with highest profit, count units
        
      // [ [1, 4, 20] , 
      //   [2, 1, 10] , 
      //   [3, 1, 40] , 
      //   [4, 1, 30] ]

      Arrays.sort(jobs, (j1, j2) -> j2[2] - j1[2]);

      // find max deadline to create result Array
      int max = 0;
      for(int[] job: jobs) {
        max = Math.max(job[1], max);
      }

      int result[] = new int[max + 1];
      for(int i = 1; i < result.length; i++) {
        result[i] = -1;
      }

      int count = 0, profit = 0;
      for(int i = 0; i < jobs.length; i++) {
        for(int j = jobs[i][1]; j > 0; j--) {
          if(result[j] == - 1) {
            result[j] = i;
            profit += jobs[i][2];
            count++;

            break;
          }
        }
      }

      return new int[] {count, profit};
    }
}