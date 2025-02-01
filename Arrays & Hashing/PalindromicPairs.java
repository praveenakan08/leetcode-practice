import java.util.*;

// TC - O(n x len(s)), SC - O(n)
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> result = new HashSet();
        Map<String, Integer> map = new HashMap();

        for(int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i); // reverse of each word and index
        }


        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            // check for "" empty string and if current word is palindrome
            
            if(map.containsKey("") && isPalindrome(word) && map.get("") != i) {
                result.add(List.of(map.get(""), i));
                result.add(List.of(i, map.get("")));
            }

            for(int j = 0; j < word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // prefix -- ll and suffix is s
                if(map.containsKey(suffix) && isPalindrome(prefix) && map.get(suffix) != i) {
                    result.add(List.of(map.get(suffix), i));
                }

                if(map.containsKey(prefix) && isPalindrome(suffix) && map.get(prefix) != i) {
                    result.add(List.of(i, map.get(prefix)));
                }   
            }
        }

        return new ArrayList(result);
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
