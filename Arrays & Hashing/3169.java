// TC - O(nlogn), SC - O(1)
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        // sort by meeting start days

        int meetDays = 0, prevEnd = 0;

        for(int[] meet: meetings) {
            int start = Math.max(prevEnd + 1, meet[0]);
            int end = meet[1];

            if(start <= end) {
                meetDays += end - start + 1;
            }

            prevEnd = Math.max(end, prevEnd);
        }

        return days - meetDays;
    }
}