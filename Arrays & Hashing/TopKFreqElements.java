// TC - O(n), SC - O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // countMap to store the counts of each num
        Map<Integer, Integer> countMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        // freqMap to store the key as count, value - list of numbers having that count
        Map<Integer, List<Integer>> freqMap = new LinkedHashMap();
        for(Integer key: countMap.keySet()) {
            int count = countMap.get(key);
            if(!freqMap.containsKey(count)) {
                freqMap.put(count, new ArrayList());
            }
            
            freqMap.get(count).add(key);
        }

        // iterate through freqMap backwards from len(nums) and extract k elements
        int count = 0;
        int[] result = new int[k];
        for(int i = nums.length; i >= 1; i--) {
            if(freqMap.containsKey(i)) {
                for(Integer element: freqMap.get(i)) {
                    result[count] = element;
                    count++;

                    if(count == k) {
                        return result;
                    }
                }  
            }
        }

        return result;
    }
}
