// TC - O(2^logn base3), SC - O(logn)
// 3^i = n
// apply log on both sides
// ilog3 = n
// i = logn base3 -- height of the recursive tree 
class Solution {

    boolean result;
    public boolean checkPowersOfThree(int n) {
        // 3^0
        // 1+   0+
        //4 1   3 0
        //13 4 10 1   [12] 3 9 0
        backtrack(0, 0, n);
        return result;
    }

    private void backtrack(int p, int currentSum, int n) {
        if(currentSum == n) {
            result = true;
            return;
        }

        if(currentSum > n || Math.pow(3, p) > n) {
            return;
        }

        currentSum += Math.pow(3, p);
        backtrack(p + 1, currentSum, n);

        currentSum -= Math.pow(3, p);
        backtrack(p + 1, currentSum, n);
    }
}