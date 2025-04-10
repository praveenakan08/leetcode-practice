// TC - O(n2), SC - O(1) - can be done with more TC because we need all substrings
class Solution {
    public int beautySum(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for(int j = i; j < s.length(); j++) {
                int max = 0, min = 0;
                ++freq[s.charAt(j) - 'a'];

                for(int k = 0; k < 26; k++) {
                    max = Math.max(max, freq[k]);
                    min = Math.min(min, freq[k]);
                }

                int beauty = max - min;
                result += beauty;                 
            }
        }

        return result;
    }
}