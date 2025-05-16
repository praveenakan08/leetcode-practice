class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        // words = ["bab","dab","cab"], groups = [1,2,2]

        // dp = [1, 2, 2]
        // parent = [-1, 0, 0]
        int n = words.length, max = 0;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(groups[i] != groups[j] 
                    && isHammingDist(words[i], words[j])
                    && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                }
            }

            if(dp[i] > max) {
                max = dp[i];
            }
        }

        List<String> result = new ArrayList();
        for(int i = 0; i < n; i++) {
            if(dp[i] == max) {
                while(i != -1) {
                    result.add(words[i]);
                    i = parent[i];
                }

                break;
            }
        }

        Collections.reverse(result);
        return result;
    }

    private boolean isHammingDist(String w1, String w2) {
        if(w1.length() != w2.length()) {
            return false;
        }

        int diff = 0;
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }

            if(diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}
