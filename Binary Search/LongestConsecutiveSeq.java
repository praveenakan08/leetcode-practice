// TC - O(n), SC - O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int i: set) {
            if(!set.contains(i - 1)) { // find starting point
                
                int temp = i, count = 0;
                while(set.contains(temp)) {
                    count++;
                    temp++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}