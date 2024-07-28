// TC - O(n), SC - O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        // non-alpha numeric - only letters and numbers
        while (left < right) {
            while(left < s.length() && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while(right >= 0 && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if(left < s.length() && right >= 0) {
                if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } 
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (Character.isLetter(c) || Character.isDigit(c));
    }
}
