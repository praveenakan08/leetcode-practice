class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue();

        for(int i = 0; i < nums.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.add(nums[i]);
            } else if(nums[i] > maxHeap.peek()) {
                maxHeap.poll(); // remove the last min element
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.poll();
    }
}   