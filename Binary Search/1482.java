class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }     

        if(m * k > bloomDay.length) {
            return -1;
        }

        int count = 0, result = 0;
        for(int i = min; i <= max; i++) {
            for(int j = 0; j < bloomDay.length; j++) {
                if(bloomDay[j] <= i) {
                    count++;
                } else {
                    result += count / k;
                    count = 0;
                }
            }

            result += count / k;
            if(result == m) {
                return i;
            }
            count = 0;
            result = 0;
        }

        return -1;
    }
}