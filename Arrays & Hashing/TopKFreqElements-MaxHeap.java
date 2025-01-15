// TC - O(nlogk), SC - O(n) 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // [0, 1] -> number, freq
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        // freq map
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key: map.keySet()) {
            maxHeap.offer(new int[]{key, map.get(key)});
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int i = 0;
        while(k != 0) {
            result[i] = maxHeap.poll()[0];
            i++;
            k--;
        }

        return result;
    }
}