// TC - O(nx2^n), SC - O(n)
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        result = new ArrayList();
        Arrays.sort(nums);

        // 1 1 2 5 6 7 10
        dfs(0, target, new ArrayList(), 0, nums);
        return result;
    }

    private void dfs(int i, int target, List<Integer> current, int currentSum, int[] nums) {

        if (currentSum == target && !result.contains(current)) {
            result.add(new ArrayList(current));
            return;
        }

        if (i >= nums.length || currentSum > target) {
            return;
        }

        currentSum += nums[i];
        current.add(nums[i]);
        dfs(i + 1, target, current, currentSum, nums);

        currentSum -= nums[i];
        current.remove(current.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(i + 1, target, current, currentSum, nums);
    }
}
