// TC - O(n), SC - O(n)
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new TreeMap<>(Comparator.reverseOrder());

        // 9 -> {18, 36, 54}
        // 7 -> {43, 7}
        for(int i = 0; i < nums.length; i++) {
            int digitSum = convertToDigitSum(nums[i]);
            if(!map.containsKey(digitSum)) {
                map.put(digitSum, new int[]{-1, -1});
            }

            if(map.containsKey(digitSum)) { 
                int[] val = map.get(digitSum);
                Arrays.sort(val);

                if(val[0] < nums[i]) {
                    val[0] = nums[i];
                }
            }
        }

        int max = -1;
        for(int key: map.keySet()) {
            int[] val = map.get(key);

            if(val[0] != -1 && val[1] != -1) {
                max = Math.max(max, val[0] + val[1]);
            }
        }
    
        return max ;
    }

    private int convertToDigitSum(int num) {
        int sum = 0;

        while(num > 0) {
            sum += num % 10; 
            num /= 10;
        }

        return sum;
    }   
}