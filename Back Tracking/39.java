class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList();
        rec(0, 0, target, nums, new ArrayList());

        return result;    
    }

    private void rec(int i, int sum, int target, int[] nums, List<Integer> current) {
        if(sum == target) {
            result.add(new ArrayList(current));
            return;
        }

        if(i >= nums.length || sum > target) {
            return;
        }

        current.add(nums[i]);
        rec(i, sum + nums[i], target, nums, current);

        current.remove(current.size() - 1);
        rec(i + 1, sum, target, nums, current);        
    }
}