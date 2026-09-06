class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high =0;
        for(int num: nums){
            high = Math.max(high,num);
        }

        while(low < high){
            int mid = low + (high-low)/2;

            if(computeSum(nums,mid) <= threshold){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int computeSum(int[] nums, int divisor){
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; 
        }
        return sum;
    }
}