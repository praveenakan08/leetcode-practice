// TC - O(n), SC - O(1)
// Cantor's Diagonalization method - flipping one bit at index i ensures that result is different from nums 
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < nums.length; i++) {
            char c = nums[i].charAt(i);
            result.append(c == '1' ? '0' : '1');
        }
        
        return result.toString();
    }
}