// TC - O(n), SC - O(sum(nums))
class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> dp = new HashSet();
        dp.add(0);

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            Set nextDp = new HashSet(dp);
            for(int element: dp) {
                nextDp.add(element + nums[i]);
            }

            dp = nextDp;
            if(dp.contains(sum / 2)) {
                return true;
            }
        }

        return dp.contains(sum / 2);
    }
}