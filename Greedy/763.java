// TC - O(n), SC - O(u) -- unique characters
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();

        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        // ababcbaca defegde hijhklij
        int size = 0, end = -1;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) > end) {
                end = map.get(s.charAt(i));     // ending index = max index of element within the frame 
            }

            size++;
            if(i == end) {
                result.add(size);
                size = 0;
                end = -1;
            }
        }

        return result;
    }
}