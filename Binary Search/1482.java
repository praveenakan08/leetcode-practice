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

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }     

        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(possible(bloomDay, mid, m, k)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0, result = 0;
        
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                count++; 
            } else {
                result += count / k;
                count = 0;
            }
        }

        result += count / k;
        return result >= m;
    } 
}

