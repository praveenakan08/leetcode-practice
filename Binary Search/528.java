// TC - O(n + Qlogn), SC - O(n)
class Solution {

    int total;
    Random rand;
    int[] nums;

    public Solution(int[] w) {

        // cumulative sum
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        
        total = w[w.length - 1];
        nums = w;
        rand = new Random();
    }
    
    public int pickIndex() {
        if(total == 0) {
            return -1;
        }

        int n = rand.nextInt(total) + 1;

        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == n) {
                return mid;
            } else if(nums[mid] < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */