// TC - O(n), SC - O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;
        Set<Integer> set = new HashSet();

        // add all unique nums
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // search for starting point and its consecutive sequence
        for (Integer i : set) {
            int current = i, count = 1;

            if (!set.contains(current - 1)) {
                current++;

                while (set.contains(current)) {
                    count++;
                    current++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
