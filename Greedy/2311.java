// TC - O(n), SC - O(1)
class Solution {
    public int longestSubsequence(String s, int k) {
        // 1. from right to left -- because the lesser powers of 2, more the length to be considered
        // 2. if 0, then +count 
        // 3. if 1, and current power 2 + previous accumulated sum <= k, then consider it, otherwise skip it. 
        int sum = 0, count = 0;

        // 0123456
        // 1001010
        // 6543210 
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                count++;
            } else if(sum + Math.pow(2, (s.length() - 1) - i) <= k) {
                count++;
                sum += Math.pow(2, (s.length() - 1) - i);
            }
        }
    
        return count;
    }
}