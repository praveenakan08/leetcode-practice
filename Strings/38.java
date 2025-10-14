class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for(int i = 0; i < n - 1; i++) {
            result = getCount(result);
        }

        return result;
    }

    private String getCount(String nums) {
        StringBuilder result = new StringBuilder();
        char c = nums.charAt(0);
        int freq = 1;

        for(int i = 1; i < nums.length(); i++) {
            if(nums.charAt(i) == c) {
                freq++;
            } else {
                result.append(freq);
                result.append(c);

                c = nums.charAt(i);
                freq = 1;
            }
        }

        result.append(freq);
        result.append(c);
        
        return result.toString();
    }
}