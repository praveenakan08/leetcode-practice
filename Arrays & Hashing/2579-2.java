// TC - O(1), SC - O(1)
class Solution {
    public long coloredCells(int n) {
        // n = 3 -> 1 + 4 * (1 + 2) -> 1 + 4*1 + 4*2 
        // 1 + 2 + 3 .. n = (n + 1) * n / 2
        // https://leetcode.com/problems/count-total-number-of-colored-cells/solutions/3257772/shortest-1-liner-with-intuition
        return  1 + (long)n * (n - 1) * 2;
    }
}