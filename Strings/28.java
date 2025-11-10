class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) {
            return 0;
        }
    
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String found = haystack.substring(i, i + needle.length());

            if(found.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}