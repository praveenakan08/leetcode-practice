// TC - O(n), SC - O(n)
class Solution {
    public int minimumOperations(int[] nums) {
        // 1. priority queue with max count at the top
        // 2. loop till the queue has max count as 1 at the top
        // 3. only add the ones which are having more than 1 count
        // 4. remove elements whose count is 1, repeat until the q is empty
        // 5. keep an index i, which keeps track of the first 3 elements
        //    no need to remove the elements exactly, just move the pointer to next 3 elements.
        int index = 0, result = 0;
        // PriorityQueue<int[]> pq = new PriorityQueue((a, b) -> b[1] - a[1]); // sorted based on count
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while(true) {
            boolean distinct = true;

            // check for distinct
            for(int key: map.keySet()) {
                if(map.get(key) > 1) {
                    distinct = false;
                }
            }

            if(distinct) {
                break;
            }

            for(int i = index; i < index + 3; i++) {
                if(i < nums.length) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
            }

            index += 3;
            result++;            
        }

        return result;
    }
}
