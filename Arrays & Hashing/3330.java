class Solution {
    public int possibleStringCount(String word) {
        int count = 1, left = 0, right = 0;

        while(right < word.length()) {
            while(right < word.length() && word.charAt(right) == word.charAt(left)) {
                right++;
            }

            count += right - left - 1;
            left = right;
        }
        
        return count;
    }
}