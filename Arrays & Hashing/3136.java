class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }

        int v = 0, c = 0;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        for(int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));

            if(!Character.isDigit(ch) && !Character.isLetter(ch)) {
                return false;
            }

            if(Character.isLetter(ch)) {
                if(vowels.contains(ch)) {
                    v++;
                } else {
                    c++;
                }
            }
        }

        if(v > 0 && c > 0) {
            return true;
        }

        return false;
    }   
}