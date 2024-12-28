// TC - n2^n, SC - O(1) 
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        dfs(0, nums, new ArrayList());

        return result;
    }

    private void dfs(int i, int nums[], List<Integer> subset) {
        if(i >= nums.length) {
            result.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i+1, nums, subset);

        subset.remove(subset.size() - 1);
        dfs(i+1, nums, subset);
    }
}