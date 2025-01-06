// TC - O(n*2^n), SC - O(n)
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        result = new ArrayList();
        result.add(new ArrayList());

        dfs(0, new ArrayList(), nums);
        return result;
    }

    private void dfs(int i, List<Integer> current, int[] nums) {
        if (i >= nums.length) {
            return;
        }

        current.add(nums[i]);
        result.add(new ArrayList(current));

        dfs(i + 1, current, nums);
        current.remove(current.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(i + 1, current, nums);
    }
}
