// TC - O(n2), SC - O(1) - can be done with more TC because we need all substrings
class Solution {
    public int beautySum(String s) {
        int result = 0;

        // aabcb
        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            
            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++) {
                    // instead of checking in j loop, we do this because, ex: "aa" -> first min is 1 and then max is 2 after 2nd a, but it should be min = 2, max = 2, FIRST NON-ZERO char freq
                    if(freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }
            
                result += (max - min);
            }
        }

        return result;
    }
}