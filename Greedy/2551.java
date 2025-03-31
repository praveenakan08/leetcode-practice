// TC - O(nlogn), SC - O(n)
class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Integer> splits = new ArrayList();
        for(int i = 0; i < weights.length - 1; i++) {
            splits.add(weights[i] + weights[i + 1]);
        }
        Collections.sort(splits);

        long max = 0, min = 0;
        for(int i = 0; i < k - 1; i++) {
            max += splits.get(splits.size() - 1 - i);
            min += splits.get(i);
        }

        return max - min;
    }
}