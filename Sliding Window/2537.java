// TC - O(n), SC - O(n)
class Solution {
    public long countGood(int[] nums, int k) {
        // k pairs (i, j) --> i < j and arr[i] == arr[j]
        // 3,1,4,3,2,2,4
        // 3 -> 0, 3
        // 2 -> 4, 5
        // 4 -> 2, 6
        Map<Integer, Integer> freq = new HashMap();
        long result = 0L, pairs = 0L;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            int value = nums[right];

            freq.put(value, freq.getOrDefault(value, 0) + 1);
            pairs += freq.getOrDefault(value, 0);

            while(pairs >= k) {
                result += nums.length - right;

                int leftVal = nums[left++];
                pairs -= freq.get(leftVal);
                freq.put(leftVal, freq.get(leftVal) - 1);
            }
        }

        return result;
    }
}
