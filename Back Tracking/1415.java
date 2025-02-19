class Solution {
    int result = 0;

    public String getHappyString(int n, int k) {
        return backtrack(n, k, "");
    }

    private String backtrack(int n, int k, String current) {
        if(current.length() == n) {
            result++;
            
            if(result == k) {
                return current;
            }

            return ""; 
        }

        for(char c = 'a'; c <= 'c'; c++) {
            if(current.length() > 0 && current.charAt(current.length() - 1) == c) {
                continue;
            }

            String intResult = backtrack(n, k, current + c);
            if(intResult != "") {
                return intResult;
            }
        }

        return "";
    }
}