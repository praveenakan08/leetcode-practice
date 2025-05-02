// TC - O(n), SC - O(n)
class Solution {
    public String pushDominoes(String dom) {
        char[] d = dom.toCharArray();
        Queue<int[]> q = new LinkedList();

        for(int i = 0; i < d.length; i++) {
            if(d[i] != '.') {
                q.add(new int[]{d[i], i});
            }
        }

        while(!q.isEmpty()) {
            int[] popped = q.poll();
            int c = popped[0], i = popped[1];

            if(c == 'L') {
                if(i > 0 && d[i - 1] == '.') {
                    d[i - 1] = 'L';
                    q.add(new int[]{'L', i - 1});
                }
            } else if(c == 'R') {
                if(i + 1 < d.length && d[i + 1] == '.') {
                    if(i + 2 < d.length && d[i + 2] == 'L') {
                        q.poll();
                    } else {
                        d[i + 1] = 'R';
                        q.add(new int[]{'R', i + 1});
                    }
                }
            }
        }
        
        return new String(d);
    }
}