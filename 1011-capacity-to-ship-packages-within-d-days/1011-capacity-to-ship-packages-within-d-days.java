class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0 , high = 0;
        for(int w: weights){
            low = Math.max(w,low);
            high += w;
        }

        while(low < high){
            int mid = low + (high - low) / 2;
            if(fun(weights,mid) <= days){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private int fun(int[] weights, int capacity){
        int load = 0,day = 1;

        for(int w: weights){
            if(load + w > capacity){
                day++;
                load = 0;
            }
            load += w;
        }
        return day;
    }
}