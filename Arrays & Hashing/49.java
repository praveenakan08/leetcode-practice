class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);

            String sortedString = new String(ch);
            if(!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList());
            }

            map.get(sortedString).add(strs[i]);
        }

        return new ArrayList(map.values());
    }
}