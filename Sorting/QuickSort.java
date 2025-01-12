// TC - O(nlogn), SC - O(n)
class Solution {
    public int[] sortArray(int[] nums) {
       quickSort(nums, 0, nums.length - 1);
       return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int pivot = partition(nums, left, right);

            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;

        while(i <= j) {
            // find element which is greater than pivot
            while(i <= right && nums[i] <= pivot) {
                i++;
            }

            while(j >= left && nums[j] > pivot) {
                j--;
            }
            
            if(i < j) {
                // swap elements
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // swap the pivot element with j
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;

        return j;
    }
}