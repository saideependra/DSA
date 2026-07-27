class Solution {
    class Pair{
        int dist;
        int x;
        int y;
        Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.dist-a.dist
        );

        for(int i = 0; i<points.length;i++){
            int x = points[i][0];
            int  y= points[i][1];

            int dist = x*x+y*y;

            pq.add(new Pair(dist,x,y));

            if (pq.size() > k) {
                pq.remove();
            }

        }

        int[][] ans = new int[k][2];

        int i = 0;
        while(!pq.isEmpty()){
            Pair p =pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }
}