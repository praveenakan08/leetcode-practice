// TC - O(n), SC - O(1) 
class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 0; i < n - 1; i++) {
            result = countFreq(result);
        }

        return result;
    }

    private String countFreq(String num) {
        StringBuilder result = new StringBuilder();
        char c = num.charAt(0);
        int freq = 1;

        for(int i = 1; i < num.length(); i++) {
            if(num.charAt(i) == c) {
                freq++;
            } else {
                result.append(freq);
                result.append(c);

                c = num.charAt(i);
                freq = 1;
            }
        }

        result.append(freq);
        result.append(c);
        
        return result.toString();
    }
}