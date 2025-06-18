class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        if(nums.length % 3 != 0) {
            return new int[nums.length / 3][3];
        }

        Arrays.sort(nums);
        int index = 0;
        for(int i = 0; i < nums.length; i+=3) {
            if(i + 2 < nums.length && nums[i + 2] - nums[i] <= k) {
                result[index] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
                index++;
            } else {
                return new int[nums.length / 3][3];
            }
        }

        return result;    
    }
}