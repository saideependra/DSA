class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
    private int merge(int[] nums,int left,int right){
        if(left>=right) return 0;

        int mid = left + (right-left)/2;

        int count = merge(nums,left,mid)+merge(nums,mid+1,right);

        int j = mid+1;
        for(int i = left;i <= mid; i++){
            while(j <= right && (long) nums[i] > 2L * nums[j]){
                j++;
            }
            count += (j - (mid + 1));
        }

        int[] merged = new int[right-left+1];
        int idx =0 , l = left, r = mid+1;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                merged[idx++] = nums[l++];
            } else {
                merged[idx++] = nums[r++];
            }
        }
        while (l <= mid) merged[idx++] = nums[l++];
        while (r <= right) merged[idx++] = nums[r++];

        System.arraycopy(merged, 0, nums, left, merged.length);

        return count;
    }
}