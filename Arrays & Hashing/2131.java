// TC - O(n), SC - O(1)
class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        int[][] count = new int[26][26];

        for(String word: words) {
            int a = word.charAt(0) - 'a', b = word.charAt(1) - 'a';

            if(count[b][a] > 0) {
                result += 4;
                count[b][a]--;
            } else {
                count[a][b]++;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(count[i][i] > 0) {
                result += 2;    // if "aa", "bb" etc exists
                break;
            }
        }

        return result;
    }
}