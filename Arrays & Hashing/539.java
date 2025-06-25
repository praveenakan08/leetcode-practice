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