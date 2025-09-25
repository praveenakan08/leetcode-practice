class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        // using maxHeap 
        Map<Character, Integer> map = new HashMap();
        // store the freqs of chars in a hashmap
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // create a maxHeap and store the freqs in descending order
        PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet()); // here we are storing chars in the map acc to the freqs of those chars in descending order

        while(!maxHeap.isEmpty()) {
            char key = maxHeap.remove();
            for(int i = 1; i <= map.get(key); i++) {
                result.append(key);
            }
        } 

        return result.toString();
    }
}