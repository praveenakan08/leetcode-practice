// TC - O(n), SC - O(1)
class Solution {
    public long coloredCells(int n) {
        long res = 1L;
        // n = 3 -> 4*0 + 4*1 + 4*2 
        for(int i = 0; i <= n - 1; i++) {
            res += (long)(4 * i);
        }

        return res;
    }
}