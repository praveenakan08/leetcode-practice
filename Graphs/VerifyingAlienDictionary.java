class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int i = 0;

        while (i < words.length - 1) {
            int j = 0;
            while (j < words[i].length() && j < words[i + 1].length()) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    break;
                }

                j++;
            }

            if (j == words[i + 1].length() && words[i].length() != words[i + 1].length()) {
                return false;
            }

            if (j < words[i].length() && j < words[i + 1].length()
                    && order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
                return false;
            }

            i++;
        }

        return true;
    }
}