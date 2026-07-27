class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minsum = nums[0]+nums[1]+nums[2];
        for(int i = 0;i<nums.length - 2 ; i++){
            int j = i+1;
            int k = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(j<k){
                int currsum=nums[i]+nums[j]+nums[k];
                if(Math.abs(currsum - target) < Math.abs(minsum-target)){
                    minsum = currsum;

                }
                if(currsum == target){
                    return currsum;
                }else if(currsum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return minsum;
    }
}