// TC - O(2^n), SC - O(logn)
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