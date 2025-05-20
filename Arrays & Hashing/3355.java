class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n];
        
        for(int[] q : queries) {
            freq[q[0]]++;
            if(q[1] + 1 < n) {
                freq[q[1] + 1]--;
            }
        }
        
        int curFreq = 0;
        for(int i = 0; i < n; i++) {
            curFreq += freq[i];
            if(curFreq < nums[i]) {
                return false;
            }
        }
        return true;
    }
}