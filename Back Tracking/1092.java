class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return backtrack(0, 0, str1, str2);
    }

    private String backtrack(int i, int j, String str1, String str2) {
        if(i == str1.length()) {
            return str2.substring(j, str2.length());
        }

        if(j == str2.length()) {
            return str1.substring(i, str1.length());
        }

        if(str1.charAt(i) == str2.charAt(j)) {
            return str1.charAt(i) + backtrack(i + 1, j + 1, str1, str2);
        }

        String res1 = str1.charAt(i) + backtrack(i + 1, j, str1, str2);
        String res2 = str2.charAt(j) + backtrack(i, j + 1, str1, str2);

        if(res1.length() < res2.length()) {
            return res1;
        } 

        return res2;
    }
}