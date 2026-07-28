class Solution {
    class Pair{
        int soliders;
        int index;
        
        Pair(int soliders,int index){
            this.soliders = soliders;
            this.index = index;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.soliders!=b.soliders) return b.soliders-a.soliders;

                return b.index-a.index;
            }
        );

        for(int i = 0; i<mat.length;i++){
            int count = 0;

            for(int num:mat[i]){
                if(num==1){
                    count++;
                }
            }
            pq.add(new Pair(count,i));

            if(pq.size()>k){
                pq.remove();
            }
        }

        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.remove().index;
        }
        return ans;
    }
}