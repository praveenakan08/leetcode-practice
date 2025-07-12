class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(freq1[i] == freq2[i]) {
                matches++;
            }
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            if(matches == 26) {
                return true;
            }

            int right = s2.charAt(i) - 'a';
            int left = s2.charAt(i - s1.length()) - 'a';

            freq2[right]++;
            if(freq1[right] == freq2[right]) {
                matches++;
            } else if(freq1[right] + 1 == freq2[right]){
                matches--;
            }

            freq2[left]--;
            if(freq1[left] == freq2[left]) {
                matches++;
            } else if(freq1[left] - 1 == freq2[left]) {
                matches--;
            }
        }

        return matches == 26;
    }
}
