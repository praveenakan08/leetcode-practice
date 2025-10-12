class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, start = 0, end = 0;
        int n = s.length();
        while (end < n) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0) {
                count += n - end;
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                start++;
            }
            end++;
        }
        return count;
    }
}

class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap();
        int result = 0, right = 0, left = 0;

        while(right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.getOrDefault('a', 0) > 0 
                && map.getOrDefault('b', 0) > 0 
                && map.getOrDefault('c', 0) > 0) {

                result += s.length() - right;
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
        }


        return result;
    }
}