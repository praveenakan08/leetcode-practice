class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {
            words[i] = words[i].trim();

            if(!words[i].isEmpty()) {
                if(i == 0) {
                    result.append(words[i]);
                } else { 
                    result.append(words[i] + " ");
                }
            }
        }

        return result.toString();
    }
}