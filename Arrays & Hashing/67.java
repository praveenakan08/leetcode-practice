class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] result = new String[s.length() + k - 1/ k];

        // abcdefghij
        for(int i = 0; i < s.length(); i++) {
            StringBuilder group = new StringBuilder();

            for(int j = 0; j < k; j++) {
                int index = i * k + j; 

                if(index < s.length()) {
                    group.append(s.charAt(index));
                } else {
                    group.append(fill);
                }

                result[i] = group.toString*()
            }
        }   

        return result;
    }
}