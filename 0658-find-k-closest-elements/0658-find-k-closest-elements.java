class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
                int dist1 = Math.abs(a-x);
                int dist2 = Math.abs(b-x);

                if(dist1!=dist2){
                    return dist2 - dist1;
                }
                return b-a;
            }
        );

        for(int num : arr){
            pq.offer(num);

            if(pq.size()>k) pq.poll();
        }
        List<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}