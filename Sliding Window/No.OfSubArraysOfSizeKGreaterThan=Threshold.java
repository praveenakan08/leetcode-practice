class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // solution 1
        int count = 0, left = 0, right = 0, sum = 0;

        // adding the first window of numbers
        while (right < arr.length && right < k) {
            sum += arr[right];
            right++;
        }

        count += sum / k >= threshold ? 1 : 0;

        while (right < arr.length) {
            sum += arr[right];
            sum -= arr[left];
            count += sum / k >= threshold ? 1 : 0;

            left++;
            right++;
        }

        return count;
    }

    // solution 2
    int count = 0, left = 0, right = 0, sum = 0;

    // adding the first window of numbers
    while(right<arr.length&&right<k)
    {
        sum += arr[right];
        right++;
    }

    count+=sum/k>=threshold?1:0;

    while(right<arr.length)
    {
        sum += arr[right];
        sum -= arr[left];
        count += sum / k >= threshold ? 1 : 0;

        left++;
        right++;
    }

    return count;
}}