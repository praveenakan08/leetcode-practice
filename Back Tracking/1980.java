class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        return backtrack(0, n, new StringBuilder(""), Arrays.asList(nums));
    }

    private String backtrack(int num, int n, StringBuilder current, List<String> nums) {
        if(current.length() == n && !nums.contains(current.toString())) {
            return current.toString();
        }

        if(num > 1 || current.length() > n) {
            return "";
        }

        current.append(num);
        String result = backtrack(num, n, current, nums);
        if(result != "") {
            return result;
        }

        current.deleteCharAt(current.length() - 1);

        result = backtrack(num + 1, n, current, nums);
        if(result != "") {
            return result;
        }

        return "";
    }
}