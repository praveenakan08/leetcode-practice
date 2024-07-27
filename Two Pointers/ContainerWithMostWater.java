class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = Integer.MIN_VALUE;

        while(left < right) {
            int area = 0;

            if(height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            } 

            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
}
