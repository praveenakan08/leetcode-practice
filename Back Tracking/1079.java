// TC - O(2^n), SC - O(n)
class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> countMap = new HashMap();
        
        for(int i = 0; i < tiles.length(); i++) {
            countMap.put(tiles.charAt(i), countMap.getOrDefault(tiles.charAt(i), 0) + 1); 
        }

        return backtrack(countMap);
    }

    private int backtrack(Map<Character, Integer> countMap) {
        int count = 0;

        for(Character key: countMap.keySet()) {
            if(countMap.get(key) > 0) {
                count += 1;
                countMap.put(key, countMap.get(key) - 1);
                count += backtrack(countMap);
                
                countMap.put(key, countMap.get(key) + 1);
            }
        }

        return count;
    }
}
