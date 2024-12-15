// TC - O(n), SC - O(1)
class Solution {
    public int totalFruit(int[] fruits) {
        int max = 1, left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap();

        while(right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2 && left < right) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            if(map.size() <= 2) {
                int sum = 0;
                for(int key: map.keySet()) {
                    sum += map.get(key);
                }

                max = Math.max(sum, max);
            }
            right++;
        }

        return max;
    }
}