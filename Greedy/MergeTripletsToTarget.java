// TC - O(n), SC - O(1)
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                continue;
            }

            if(triplets[i][0] == target[0]) {
                x = true;
            }
            if(triplets[i][1] == target[1]) {
                y = true;
            }
            if(triplets[i][2] == target[2]) {
                z = true;
            }
        }

        if(x && y && z) {
            return true;
        }

        return false;
    }
}
