class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0;

        for(int i = 1; i <= n; i++) {
            int sum = sumOfDigits(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            max = Math.max(max, map.get(sum));
        }

        int result = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == max) {
                result++;
            }
        }

        return result;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
