class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long need = (long)m*k;

        if(need > bloomDay.length) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while(low < high){
            int mid = low + (high - low)/2;
            if(canMake(bloomDay,mid,m,k)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canMake(int[] bloomDay,int day, int m,int k){
        int bouquet = 0, streak = 0;

        for(int bloom: bloomDay){
            if(bloom <= day){
                streak++;
                if(streak == k){
                    bouquet++;
                    streak = 0;
                }
            }else{
                streak = 0;
            }
        }
        return bouquet >= m;
    }
}