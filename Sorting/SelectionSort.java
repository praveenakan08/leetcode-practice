// TC - O(nxn), SC - O(1)
class Solution {
    public int[] sortArray(int[] nums) {
        // selection sort
        for(int i = 0; i < nums.length; i++) {
            int minIndex = i;

            for(int j = i + 1; j < nums.length; j++) {
                // find minimum or maximum
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

             // swap min with current element
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }
}

private int[] sort(int[] nums) {

    for(int i = 0; i < nums.length; i++) {
        for(int j = i + 1; j < nums.length;)
    } 
}