class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;   // 1 car repaired in 1 min 
        long right = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars; // max range of minutes to repair all cars 
        
        // find the min minutes using binary search 
        while(left < right) {
            long mid = (left + right) / 2;    // mid - total amount of time to repair cars now

            if(canRepairAllCars(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left; // since we need the minimum value of time to repair all cars
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long totalTime) {
        long totalRepaired = 0;

        // total minutes = r x n x n
        // sqrt(min / r) = n

        for(int i = 0; i < ranks.length; i++) {
            totalRepaired += Math.sqrt(totalTime / ranks[i]); 
            if(totalRepaired >= cars) {
                return true;
            }
        } 

        return false;
    }
}