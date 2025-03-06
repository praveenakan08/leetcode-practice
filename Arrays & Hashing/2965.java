// TC - O(n), SC - O(n)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int range = grid.length * grid.length;
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        for(int i = 1; i <= range; i++) {
            if(!map.containsKey(i)) {
                result[1] = i;
            } else if(map.get(i) == 2) {
                result[0] = i;
            }
        }

        return result;
    }
}