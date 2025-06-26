class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size(); i++) {
            String[] hm = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }

        Arrays.sort(minutes);

        for(int i = 0; i < minutes.length - 1; i++) {
            min = Math.min(min, minutes[i + 1] - minutes[i]);
        }

        return Math.min(min, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // 1. convert the times into minutes 
        // 2. sort the array
        // 3. check adj. elements if min is found 

        int min = Integer.MAX_VALUE;
        int minutes[] = new int[timePoints.size()];

        for(int i = 0; i < timePoints.size(); i++) {
            String[] str = timePoints.get(i).split(":");
            minutes[i] = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        } 

        Arrays.sort(minutes);
        for(int i = 1; i < minutes.length; i++) {
            min = Math.min(minutes[i] - minutes[i - 1], min);
        }
        
        return Math.min(min, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}