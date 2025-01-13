// TC - O(n), SC - O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();
        
        // a -> 8 last index of a 
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int size = 0, end = -1;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) > end) {
                end = map.get(s.charAt(i));
            }

            size++;

            if(i == end) {
                end = -1;
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}