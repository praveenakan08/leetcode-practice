// TC - O(n), SC - O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> set = new HashSet();

        while(right < s.length()) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            max = Math.max(max, set.size());
            right++;
        }

        return max;
    }
}