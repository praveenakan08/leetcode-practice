class Solution {
        public int minCapability(int[] A, int k) {
        int left = 1, right = (int)1e9, n = A.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i)
                if (A[i] <= mid) {
                    take += 1;
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left; //left == right
    }

    // sol 2
    public int minCapability(int[] A, int k) {
        // [2, 3, 5, 9]  k = 2
        int left = Arrays.stream(A).min().getAsInt(), right = Arrays.stream(A).max().getAsInt(), result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(checkCapability(A, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }  

    private boolean checkCapability(int A[], int k, int max) {
        int count = 0, i = 0;

        while(i < A.length) {
            if(A[i] <= max) {
                count++;
                i += 2;
            } else {
                i += 1;
            }

            if(count == k) {
                return true;
            }
        }
        
        return false;
        
    }
}