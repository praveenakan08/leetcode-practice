class Solution {
    public int strStr(String haystack, String needle) {
    
        for(int i = 0; i < haystack.length; i++) {
            int found = haystack.substring(i, i + 3);
            

            if(found > 0) {
                return found;
            }
        }

        return -1;
    }
}