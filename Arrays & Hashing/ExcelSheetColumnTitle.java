class Solution {
    public int titleToNumber(String columnTitle) {
        int c[] = new int[26];
        for(int i = 0; i < 26; i++) {
            c[i] = i + 1;
        }

        int result = 0, inc = 1;
        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            result += c[columnTitle.charAt(i) - 'A'] * inc;
            inc *= 26;
        }

        return result;
    }
}