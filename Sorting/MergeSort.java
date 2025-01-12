// TC - O(nlogn), SC - O(n)
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        int[] r = new int[right - mid];

        for(int i = 0; i < l.length; i++) {
            l[i] = nums[left + i];
        }

        for(int i = 0; i < r.length; i++) {
            r[i] = nums[mid + i + 1];
        }

        int i = 0, j = 0, k = left; 

        while(i < l.length && j < r.length) {
            if(l[i] <= r[j]) {
                nums[k] = l[i];
                i++;
            } else {
                nums[k] = r[j];
                j++;
            }

            k++;
        }

        while(i < l.length) {
            nums[k] = l[i];
            i++;
            k++;
        }

        while(j < r.length) {
            nums[k] = r[j];
            j++;
            k++;
        }
    }
}