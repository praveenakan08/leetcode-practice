// 986
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
     // 1, 2, 3
        // 2, 3, 4
     // [2, 3]
        int i = 0, j = 0, k = 0;
        List<int[]> result = new ArrayList<>();
        while(i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);

            if(left <= right) {
                result.add(new int[]{left, right});
            }
            
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
         
        return result.toArray(new int[result.size()][2]);
    }
}