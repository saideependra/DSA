class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        int[] count = new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.freq-a.freq
        );

        for(int i = 0; i<26; i++){
            if(count[i]>0){
                pq.offer(new Pair((char)('a'+i),count[i]));
            }
        }
        StringBuilder ans = new StringBuilder();

        while(pq.size()>=2){
            Pair first = pq.poll();
            Pair second = pq.poll();

            ans.append(first.ch);
            ans.append(second.ch);

            first.freq--;
            second.freq--;

            if(first.freq>0){
                pq.offer(first);
            }
            if(second.freq>0){
                pq.offer(second);
            }
        }
        if(!pq.isEmpty()){
            Pair last = pq.poll();
            if (last.freq > 1)
                return "";

            ans.append(last.ch);
        }
        return ans.toString();

    }
}