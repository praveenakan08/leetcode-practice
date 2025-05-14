class Solution {
    public int lengthAfterTransformations(String s, int t) {
        // abcyy t = 2
        int count = 0;
        StringBuilder result = new StringBuilder(s);
        
        while(count != t) {
            // abcyy
            StringBuilder temp = new StringBuilder();

            // temp = []
            // result = bcdzz
            // count = 1
            for(int i = 0; i < result.length(); i++) {
                if(result.charAt(i) == 'z') {
                    temp.append("ab");
                } else {
                    temp.append((char) (result.charAt(i) + 1));
                }
            }

            result = new StringBuilder(temp);
            count++;
        }

        return result.length();
    }

    class Solution {
    private int modAdd(int a, int b) {
        int mod = 1000000007;
        a %= mod; b %= mod;

        return ((a + b) % mod + mod) % mod;
    }

    public int lengthAfterTransformations(String s, int t) {
        int[] c = new int[26];
        for(int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }

        while(t-- > 0) {
            int[] cur = new int[26];

            for(int j = 0; j < 26; j++) {
                if(j == 25 && c[j] > 0) { // if z, then increase freq of a and b
                    cur[0] = modAdd(cur[0], c[j]);
                    cur[1] = modAdd(cur[1], c[j]);
                } else {
                    if(j < 25) {
                        cur[j + 1] = modAdd(cur[j + 1], c[j]);
                    }
                }
            }

            c = cur;
        }

        int result = 0;
        for(int i = 0; i < c.length; i++) {
            result += c[i];
        }

        return result;
    }
}

}
