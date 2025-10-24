class Solution {
    public int maximumUnits(int[][] nums, int k) {
        Arrays.sort(nums, (a, b) -> b[1] - a[1]); // sort by number of units in each box
        // more the number of units = max

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(k <= 0) {
                break;
            }

            int min = Math.min(nums[i][0], k);
            k -= min;
            result += min * nums[i][1]; 
        } 

        return result;
    }
}