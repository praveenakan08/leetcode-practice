class Solution {
    public int maxDiff(int num) {
        char replaceNot9 = 0;
        char[] nums = String.valueOf(num).toCharArray();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != '9') {
                replaceNot9 = nums[i];
                break;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == replaceNot9) {
                nums[i] = '9';
            }
        }

        int a = Integer.parseInt(new String(nums)); // 9999
        // if number != 0 -> is in the first index then replace all the occurences with 1 
        // if number != 0 -> is in the next index other than first and last index is != number found  
                // then replace all occurences with 0
                            
        nums = String.valueOf(num).toCharArray();
        char replaceMin = 0;
        int minIndex = -1;
        char replaceWith = '1';
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 && nums[i] != '1') {
                minIndex = i;
                replaceMin = nums[i];
                replaceWith = '1';
                break;
            } 
            
            if(i > 0 && nums[i] != '0' && nums[i] != '1') {
                minIndex = i;
                replaceMin = nums[i];
                replaceWith = '0';
                break;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == replaceMin) {
                nums[i] = replaceWith;
            }
        }

        int b = Integer.parseInt(new String(nums));

        if(b == 0) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = '1';
            }
        }

        b = Integer.parseInt(new String(nums));
        return a - b;
    }       
}