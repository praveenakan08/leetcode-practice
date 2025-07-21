class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int j = 0, k = 0;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0  && nums[i] != nums[i - 1])) {
                j = i + 1; k = nums.length - 1;

                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        result.add(List.of(nums[i], nums[j], nums[k]));

                        while(j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }

                        while(j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }

                        j++;
                        k--;
                    } else if(nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return result;
    }
}