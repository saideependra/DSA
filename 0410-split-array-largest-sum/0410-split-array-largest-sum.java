class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countSplits(nums, mid) <= k) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }

        return low;
    }

    private int countSplits(int[] nums, int maxSum) {
        int splits = 1, currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                splits++;
                currentSum = 0;
            }
            currentSum += num;
        }

        return splits;
    }
}