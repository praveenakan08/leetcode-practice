class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // n -> piles
        // h -> hours
        // bananas per hour -> k

        // 1. calculate total
        // 2. from hour 1 to hour 8
        // 3. min k = initial is min of piles
        
        // [3, 6, 7, 11]
        // k = 3

        // hour 1 -> [0, 6, 7, 11]
        // hour 2 -> [0, 3, 7, 11]
        // hour 3 -> [0, 0, 7, 11]
        // hour 4 -> [0, 0, 4, 11]
        // hour 5 -> [0, 0, 1, 11]
        // hour 6 -> [0, 0, 0, 11]
        // hour 7 -> ... cannot finish all

        // k = 4
        // h1 -> [0, 6, 7, 11]
        // h2 -> [0, 2, 7, 11]
        // h3 -> [0, 0, 3, 11]
        // h4 -> [0, 0, 0, 11]
        // h5 -> [0, 0, 0, 7]
        // h6 -> [0, 0, 0, 3]
        // h7 -> [0, 0, 0, 0]

        int k = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            k = Math.min(k, piles[i]);
            max = Math.max(max, piles[i]);
        }

        while(k <= max) {
            int[] newPiles = Arrays.copyOf(piles, piles.length);

            if(!findK(k, newPiles, h)) {
                k++;
            } else {
                return k;
            }
        }

        return k;
    }

    private boolean findK(int k, int[] piles, int h) {
        int j = 0;
        for(int i = 1; i <= h; i++) {
            j = 0;
            while(j < piles.length && piles[j] == 0) {
                j++;
            }

            if(j < piles.length) {
                if(piles[j] < k) {
                    piles[j] = 0;
                } else {
                    piles[j] = piles[j] - k;
                }
            }
        }

        for(int i = 0; i < piles.length; i++) {
            if(piles[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // n -> piles
        // h -> hours
        // bananas per hour -> k

        // 1. calculate total
        // 2. from hour 1 to hour 8
        // 3. min k = initial is min of piles
        
        // [3, 6, 7, 11]
        // k = 3

        // hour 1 -> [0, 6, 7, 11]
        // hour 2 -> [0, 3, 7, 11]
        // hour 3 -> [0, 0, 7, 11]
        // hour 4 -> [0, 0, 4, 11]
        // hour 5 -> [0, 0, 1, 11]
        // hour 6 -> [0, 0, 0, 11]
        // hour 7 -> ... cannot finish all

        // k = 4
        // h1 -> [0, 6, 7, 11]
        // h2 -> [0, 2, 7, 11]
        // h3 -> [0, 0, 3, 11]
        // h4 -> [0, 0, 0, 11]
        // h5 -> [0, 0, 0, 7]
        // h6 -> [0, 0, 0, 3]
        // h7 -> [0, 0, 0, 0]

        int left = 1, right = 1;
        for(int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while(left < right) {
            int mid = (left + right) / 2;

            if(findK(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private boolean findK(int k, int[] piles, int h) {
        double totalHours = 0;

        for(int i = 0; i < piles.length; i++) {
            totalHours += Math.ceil((double) piles[i] / k);
        }
        
        return totalHours <= h;
    }
}