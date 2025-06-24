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

import java.util.*;

class Solution {

    Random rand;
    int[] nums;
    int total;

    public Solution(int[] w) {
        rand = new Random();

        // cumulative sum stored in w[] -- more the sum, more prob
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }

        // [1, 3]
        // w -> [1, 4]
        // buckets -> [(0, 1), (1, 4)]

        // total = 4
        total = w[w.length - 1];
        nums = w;
    }
    
    public int pickIndex() {
        if(total == 0) {
            return -1;
        }

        int num = rand.nextInt(total) + 1; 

        // binary search for correct bucket 
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == num) {
                return mid;
            } else if(nums[mid] < num) {
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