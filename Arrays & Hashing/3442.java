class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new TreeMap();
        int max = 0, min = s.length();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Character key: map.keySet()) {
            if(map.get(key) % 2 != 0) {
                max = Math.max(max, map.get(key));
            }

            if(map.get(key) % 2 == 0) {
                min = Math.min(min, map.get(key));
            }
        }

        return max - min;
    }
}