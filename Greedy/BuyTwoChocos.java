// TC - O(n), SC - T(1)
class Solution {
    public int buyChoco(int[] prices, int money) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < c1) {
                c2 = c1;
                c1 = prices[i];
            } else if (prices[i] < c2) {
                c2 = prices[i];
            }
        }

        if (money - (c1 + c2) >= 0) {
            return money - (c1 + c2);
        }

        return money;
    }
}