// len(strs[i]) = l
// TC - O(n + llogl), SC - O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);

            String key = String.valueOf(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(strs[i]);
        }

        return new ArrayList(map.values());
    }
}
