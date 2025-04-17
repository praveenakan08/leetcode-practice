class Solution {
    public int countPairs(int[] nums, int k) {
        // 3,1,2,2,2,1,3
        // k = 2 
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], a -> new ArrayList()).add(i);
        }

        int count = 0;
        for(List<Integer> indices: map.values()) {
            for(int i = 0; i < indices.size(); i++) {
                for(int j = i + 1; j < indices.size(); j++) {
                    if(indices.get(i) * indices.get(j) % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}