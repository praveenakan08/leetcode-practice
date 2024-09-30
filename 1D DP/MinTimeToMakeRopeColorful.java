// TC - O(n), SC - O(1)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        char[] c = colors.toCharArray();

        for (int i = 1; i < c.length; i++) {
            if (c[i - 1] == c[i]) {
                if (neededTime[i - 1] < neededTime[i]) {
                    cost += neededTime[i - 1];
                } else {
                    cost += neededTime[i];
                    c[i] = c[i - 1];
                    neededTime[i] = neededTime[i - 1];
                }
            }
        }

        return cost;
    }
}
