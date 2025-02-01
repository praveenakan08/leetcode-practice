// TC - O(n), SC - O(1)
// 849
class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = Integer.MIN_VALUE;
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];

        int nearestOne = -seats.length;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                nearestOne = i;
            } else {
                left[i] = i - nearestOne;
            }
        }

        nearestOne = 2 * seats.length;
        for(int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1) {
                nearestOne = i;
            } else {
                right[i] = nearestOne - i;
            }
        }

        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                max = Math.max(max, Math.min(left[i], right[i]));
            }
        }

        return max;
    }
}