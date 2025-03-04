// TC - O(logn base3), SC - O(1)
class Solution {

    public boolean checkPowersOfThree(int n) {
        // ex: n = 12 
        // i = 2 -- 3^2 = 9 < 12
        
        // i = 2 -- 9 <= 12 -- 12 - 9 = 3
        // i = 1 -- 3 <= 3 -- 3 - 3 = 0
        // return if n == 0

        int i = 0;
        while(Math.pow(3, i) <= n) {
            i++;
        }

        while(i >= 0) {
            double power = Math.pow(3, i);
            if(power <= n) {
                n -= power;
            } 

            i--;
        }

        return n == 0;
    }
}