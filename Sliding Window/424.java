class Solution {
    public int characterReplacement(String s, int k) {
        // ABAB k = 2
        int[] c = new int[26];
        int left = 0, right = 0, max = 0, maxFreq = 0;

        while(right < s.length()) {
            c[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, c[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k) {
                c[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max((right - left + 1), max);
            right++;
        }

        return max;
    }
}
