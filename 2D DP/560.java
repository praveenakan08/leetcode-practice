public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
      
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

        public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(rec(i, nums, k)) {
                count++;
            }
        }

        return count;
    }

    private boolean rec(int i, int[] nums, int target) {
        if(target == 0) {
            return true;
        }

        if(i == 0) {
            return nums[i] == target;
        }

        if(i < 0 || nums[i] > target) {
            return false; 
        }

        boolean include = rec(i - 1, nums, target - nums[i]);
        boolean notInclude = rec(i - 1, nums,  target); 

        return include || notInclude;
    }
}