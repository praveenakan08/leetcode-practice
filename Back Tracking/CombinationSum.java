// TC - O(2^t)
class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList();
        dfs(0, 0, new ArrayList(), nums, target);

        return result;
    }

    private void dfs(int i, int currentSum, List<Integer> subset, int[] nums, int target) {
        if(i >= nums.length || currentSum > target) {
            return;
        }

        if(currentSum == target) {
            result.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        currentSum += nums[i];
        dfs(i, currentSum, subset, nums, target);

        subset.remove(subset.size() - 1);
        currentSum -= nums[i];
        dfs(i + 1, currentSum, subset, nums, target);
    }
}
