// TC - O(n), SC - O(n)
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap();

        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]); 
        }

        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]); 
        }

        int[][] result = new int[map.size()][2];
        int k = 0;
        for(int key: map.keySet()) {
            result[k][0] = key;
            result[k][1] = map.get(key);

            k++;
        }

        return result;
    }
}