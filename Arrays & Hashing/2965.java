// TC - O(n), SC - O(n)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int range = grid.length * grid.length;
        Map<Integer, Integer> map = new HashMap();

        for(int i = 1; i <= range; i++) {
            map.put(i, 0);
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(map.get(grid[i][j]) == 1) {
                    result[0] = grid[i][j];
                }
            
                map.put(grid[i][j], map.get(grid[i][j]) + 1);
            }
        }

        for(int i = 1; i <= range; i++) {
            if(map.get(i) == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}