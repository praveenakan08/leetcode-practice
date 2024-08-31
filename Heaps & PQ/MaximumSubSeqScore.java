// TC - O(nlogn + nlogk), SC - O(k)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // sort nums2 in desc order
        // nums -> 2 cols -> nums1 and nums2
        int[][] nums = new int[nums1.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[] { nums1[i], nums2[i] };
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        // for storing the nums1 elements in max heap
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        long sum = 0, max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // till k elements are reached
            // 1. add nums1 to q
            // 2. calculate sum
            q.add(nums[i][0]);
            sum += nums[i][0];

            if (q.size() > k) {
                // if current nums1 > q element - remove last element and add to q
                // remove the value from sum and add the current element to sum
                sum -= q.poll();
            }

            if (q.size() == k) {
                max = Math.max(max, (nums[i][1] * sum));
            }
        }

        return max;
    }
}