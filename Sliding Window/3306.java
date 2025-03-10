// TC - O(n), SC - O(1)
class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtleastk(word, k) - countAtleastk(word, k + 1);
    }

    private long countAtleastk(String word, int k) {
        int n = word.length(), consonants = 0, left = 0;
        long result = 0L;
        Map<Character, Integer> vowelMap = new HashMap();

        for(int right = 0; right < n; right++) {
            char c = word.charAt(right);

            if(isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }


            while(vowelMap.size() == 5 && consonants >= k) {
                result += n - right;
                
                char leftChar = word.charAt(left);
                if(isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }
        
        return result;
    }   

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}