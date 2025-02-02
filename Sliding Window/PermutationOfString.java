class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        int matches = 0;

        for(int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(c1[i] == c2[i]) {
                matches++;
            }
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            if(matches == 26) {
                return true;
            }

            int right = s2.charAt(i) - 'a';
            int left = s2.charAt(i - s1.length()) - 'a';


            c2[right]++;
            if(c2[right] == c1[right]) {
                matches++;
            } else if(c2[right] == c1[right] + 1) {
                matches--;
            }

            c2[left]--;
            if(c2[left] == c1[left]) {
                matches++;
            } else if(c2[left] == c1[left] - 1) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}