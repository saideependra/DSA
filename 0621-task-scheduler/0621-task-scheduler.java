class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(int a: tasks){
            freq[a-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq){
            if(f>0) pq.offer(f);
        }

        int time = 0;

        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> leftover = new ArrayList<>();
            int used = 0;

            for(int i = 0;i<cycle && !pq.isEmpty(); i++){
                int count = pq.poll();
                used++;
                if(count>1){
                    leftover.add(count-1);
                }

            }
            for(int l:leftover){
                pq.offer(l);
            }
            time += pq.isEmpty() ?used:cycle;
        }
        return time;
    }
}