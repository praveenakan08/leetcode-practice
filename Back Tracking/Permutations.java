// TC - O(n! x n^2)
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();
        dfs(new ArrayList(), nums);

        return result;   
    }

    private void dfs(List<Integer> subset, int nums[]) {
        if(subset.size() == nums.length) {
            result.add(new ArrayList(subset));
            return; 
        }

        for(int i: nums) {
            if(subset.contains(i)) {
                continue;
            }

            subset.add(i);
            dfs(subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}