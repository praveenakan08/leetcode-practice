// TC - O(n), SC - O(k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k, mid = 0;
        List<Integer> result = new ArrayList();

        while(left < right) {
            mid = left + (right - left) / 2;
            
            if(x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        for(int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}