class Solution {
    public int findPlatform(int[] a, int[] d) {
        // Arrival = [900, 940, 950, 1100, 1500, 1800] , 
        // Departure = [910, 1200, 1120, 1130, 1900, 2000]

        int min = 1;
        Map<Integer, int[]> map = new HashMap(); // platform number, occupied
        map.put(map.size() + 1, new int[]{a[0], d[0]}); // first train needs platform

        for(int i = 1; i < a.length; i++) {
            boolean found = false;

            // update platform status
            for(int key: map.keySet()) {
                // if existing train departure is less than current train arrival, then update
                if(map.get(key)[1] < a[i]) {
                    map.put(key, new int[]{a[i], d[i]});
                    found = true;
                    break;
                }
            }

            if(!found) {
                map.put(map.size() + 1, new int[] {a[i], d[i]});
            }
        }

        return map.size();
    }
}
