class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        if (s.equals("")) {
            result.add(new ArrayList<String>());
            return result;
        }

        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, i + 1)) {

                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    result.add(list);
                }
            }
        }

        return result;  
    }

    private boolean isPalindrome(String s, int n) {

        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if (s.equals("")) {
            result.add(new ArrayList<String>());
            return result;
        }

        dfs(0, s, new ArrayList());
        return result;  
    }

    private void dfs(int i, String s, List<String> current) {
        if(i >= s.length()) {
            result.add(new ArrayList(current));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                current.add(s.substring(i, j + 1));
                dfs(j + 1, s, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}