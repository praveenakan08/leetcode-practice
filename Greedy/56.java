class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);

        // [[1,3],[2,6],[8,10],[15,18]]
        for(int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];

            if(curStart <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);

            } else {
                result.add(intervals[i]);
            }
        }   

        return result.toArray(new int[result.size()][]);
    }
}