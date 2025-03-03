// TC - O(n), SC - O(n)
// we cannot solve this in-place because, we cannot preserve the relative ordering
// of the elements acc to quick sort, so take result array.
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i = 0, j = nums.length - 1, k = 0, l = nums.length - 1;
        int[] result = new int[nums.length];

        while(i < nums.length) {
            if(nums[i] < pivot) {
                result[k++] = nums[i];
            }

            i++;
        }

        while(j >= 0) {
            if(nums[j] > pivot) {
                result[l--] = nums[j];
            }

            j--;
        }

        while(k <= l) {
            result[k++] = pivot;
        }

        return result;
    }
}