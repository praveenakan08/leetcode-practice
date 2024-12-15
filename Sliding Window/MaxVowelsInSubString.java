// TC - O(n), SC - O(1)
class Solution {
    public int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE, left = 0, right = 0, vcount = 0;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        while(right < s.length()) {
            if(right - left + 1 > k) {
                if(vowels.contains(s.charAt(left))) {
                    vcount--;
                }
                
                left++;
            }

            if(vowels.contains(s.charAt(right))) {
                vcount++;
            }

            right++;

            max = Math.max(vcount, max);
        }

        return max;
    }
}