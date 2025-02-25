class Solution {
    public int numOfSubarrays(int[] arr) {
        int result = 0, prefixSum = 0, evenCount = 1, oddCount = 0;
        int mod = 1_000_000_007;

        for (int num: arr) {
            prefixSum += num;

            if (prefixSum % 2 != 0) {
                result = (result + evenCount) % mod;
                oddCount++;
            } else {
                result = (result + oddCount) % mod;
                evenCount++;
            }
        }

        return result;
    }
}
