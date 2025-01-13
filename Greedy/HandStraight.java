// TC - O(nlogn), SC - O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap();
        for(int i = 0; i < hand.length; i++) {
            countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(countMap.keySet());
        while(!minHeap.isEmpty()) {
            int min = minHeap.peek();

            for(int i = min; i < min + groupSize; i++) {
                if(!countMap.containsKey(i)) {
                    return false;
                }

                countMap.put(i, countMap.get(i) - 1);
                if (countMap.get(i) == 0) {
                    if (i != minHeap.peek())
                        return false;

                    minHeap.poll();
                }
            }
        }

        return true;
    }
}